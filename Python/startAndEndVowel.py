import re


pattern = re.compile(r'\b[aeiouAEIOU]\w*[aeiouAEIOU]\b')

with open('hello.txt', 'r') as file:
    content = file.read()

words = pattern.findall(content)
if not words:
    print("No such words found")
else:
    print("Words that start and end with a vowel:", words)


