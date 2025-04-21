read -p "Enter the num 1:" num1
read -p "Enter the num 2:" num2
read -p "Enter the num 3:" num3
if [ $num1 -gt $num2 -a $num1 -gt $num3 ]
then
echo "$num1 is greater"
elif [ $num2 -gt $num3 ]
then 
echo "$num2 is greater"
else
echo "$num3 is greater"
fi

# output

# Enter the num 1:10
# Enter the num 2:20
# Enter the num 3:30
# 30 is greater
