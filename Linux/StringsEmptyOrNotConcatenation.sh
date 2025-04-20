# whether two strings are empty or not and concatenate if not empty

echo "Enter the two String"
read n1
read n2

if [ -z $n1 ]
then 
echo "The n1 String is empty"
else
echo "The $n1 String is not empty"
str=$n1$n2
echo "Concatenated String is $str"
fi

# output

# Enter the two String
# hai 
# hello
# The hai String is not empty
# Concatenated String is haihello
