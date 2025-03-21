
num = int(input("Enter a number: "))  # Convert input to an integer
factorial = 1

for i in range(1, num + 1):
    factorial *= i  # Use *= instead of *-

print("The factorial of", num, "is", factorial)
