package main	

import (
	"html/template"
	"log"
	"net/http"
)

//Handler Function for the Homepage
func homeHandler(w http.ResponseWriter, r *http.Request) {
	tmpl, err := template.ParseFiles("templates/index.html")
	if err != nil {
		http.Error(w, "Error loading template", http.StatusInternalServerError)
		return
	}
	tmpl.Execute(w, nil)
}

func main() {
	http.HandleFunc("/", homeHandler) //Route for the homepage
	http.Handle("/static/", http.StripPrefix("/static", http.FileServer(http.Dir("static"))))


	log.Println("Server is runnning on http://localhost:8080")
	http.ListenAndServe(":8080", nil) //Start the server on port 8080
}