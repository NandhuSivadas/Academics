n=int(input("Enter Percentage:"))
if n>=90:
    print("A+")
elif n>=80 and n<90:
    print("A")
elif n>=70 and n<80:
    print("B+")
elif n>=55 and n<70:
    print("B")
else:
    print("Failed")