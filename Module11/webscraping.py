import requests
from bs4 import BeautifulSoup
import json

def scrap_google_jobs(job_title, location, num_pages):
    base_url = f"https://www.google.com/search?q=site:indeed.com+{job_title}+jobs+in+{location}"
    headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"}
    jobs = []

    for page in range(num_pages):
        url = f"{base_url}&start={page * 10}"
        response = requests.get(url, headers=headers)
        soup = BeautifulSoup(response.text, 'html.parser')
        
        # Look for job links that point to Indeed
        job_links = soup.find_all("a", href=True)
        for link in job_links:
            href = link['href']
            if "indeed.com" in href:
                title = link.text.strip()
                jobs.append({"Title": title, "URL": href})
    
    return jobs

def save_to_json(jobs, filename):
    with open(filename, 'w') as f:
        json.dump(jobs, f, indent=4)

if __name__ == "__main__":
    job_title = input("Enter Job Title: ")
    location = input("Enter Job Location: ")
    num_pages = int(input("Enter number of pages: "))

    jobs = scrap_google_jobs(job_title, location, num_pages)
    save_to_json(jobs, 'google_jobs.json')
    print(f"Scraped {len(jobs)} job listings. Saved to google_jobs.json")


    