
file_name = "hello.txt"


content_to_append = input("Enter the content to append to the file: ")


with open(file_name, "a") as file:
    file.write(content_to_append + "\n")

print(f"Content successfully appended to {file_name}.")
