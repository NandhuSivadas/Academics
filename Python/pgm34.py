import re


file_path = "hello.txt" 


email_pattern = re.compile(r'[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}')


email_addresses = []


with open(file_path, 'r') as file:
    for line in file:
        email_addresses.extend(email_pattern.findall(line))


print(email_addresses)
