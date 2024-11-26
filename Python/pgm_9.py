n = input("Enter the String: ")
if n.endswith("ing"):
    print(n[:-3] + "ly")  
else:
    print(n + "ing")  


