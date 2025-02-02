
file_path = "hello.txt"  

lines = []
with open(file_path, 'r') as file:
    lines = file.readlines()


lines = [line.strip() for line in lines]


print(lines)
