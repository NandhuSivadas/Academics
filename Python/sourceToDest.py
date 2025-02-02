
with open('hello.txt', 'r') as src_file:
    lines = src_file.readlines()

with open('dest.txt', 'w') as tgt_file:
    for i, line in enumerate(lines):
        if i % 2 == 0:  
            tgt_file.write(line)

print("Odd lines copied successfully to target.txt.")


#to display the lines copied



# with open('dest.txt', 'r') as tgt_file:
#     copied_lines = tgt_file.readlines()
#     for line in copied_lines:
#         print(line.strip())