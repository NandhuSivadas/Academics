file_name = "hello.txt"


with open(file_name, "r") as file:
    lines = file.readlines()

lengthiest_line = max(lines, key=len)
print("The lengthiest line is:")
print(lengthiest_line.strip())
