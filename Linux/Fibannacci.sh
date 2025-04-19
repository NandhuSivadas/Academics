echo "Enter :"
read num
a=1
b=1
c=0
echo "The Fibannacci series are:"
while [ $num -gt 1 ]
do
echo -n "$a "
c=$(( a + b ))
a=$b
b=$c
num=$((num - 1))
done


# output

# Enter :
# 5
# The Fibannacci series are:
# 1 1 2 3 