import re

file_name = "hello.txt"
#  phone numbers follow a standard pattern like 123-456-7890.
with open(file_name, "r") as file:
    content = file.read()

phone_numbers = re.findall(r"\b\d{3}[-]\d{3}[-]\d{4}\b", content)
print("Extracted phone numbers:")
print("\n".join(phone_numbers))
