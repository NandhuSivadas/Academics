
# n=int(input("Enter:"))
# even=[i for i in range(n) if(i%2==0)]
# a=even.split(',')
# print(a)


# n=int(input("Enter:"))
# sqr=[i*i for i in range(n) if(i%2==0)]
# print(sqr)


# n=input("Enter:")
# a=list(map(int, n.split(',')))
# print(a)
# k=[i for i in a  if(i%2==0)]
# print(k)

# n=input("Enter:")
# a=list(map(int,n.split()))
# a.sort()
# print(a[2])


# list=[1,2,3,4,5,6,7]
# print("".join(map(str,list)))


def sum_of_n(n):
    if n == 0:
        return 0
    else:
        return n + sum_of_n(n - 1)

# Call the function and print the result
result = sum_of_n(10)
print(result)
