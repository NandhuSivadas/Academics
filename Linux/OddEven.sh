read -p "Enter:" num
if [ $((num % 2)) -eq 0 ]
then 
echo "$num is even"
else
echo "$num is odd"
fi

# output

# Enter:5
# 5 is odd
