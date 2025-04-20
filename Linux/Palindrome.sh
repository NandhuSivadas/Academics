read -p "Enter the string:" str
reversed=$(echo "$str" | rev)
if [ $str == $reversed ]
then
echo "Palinrome"
else
echo "not palindrome"
fi


# output

# Enter the string:hello
# not palindrome
