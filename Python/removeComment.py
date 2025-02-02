file_name = "hello.txt"
output_file = "dest.txt"

# Removing comment lines
with open(file_name, "r") as file:
    lines = file.readlines()

# Writing non-comment lines to a new file
with open(output_file, "w") as file:
    for line in lines:
        if not line.strip().startswith("#"):
            file.write(line)

print(f"Comments removed. Cleaned content saved to {output_file}.")
