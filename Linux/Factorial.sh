echo "Enter :"
read num
fact=1
k=1
while [ $fact -le $num ]
do
k=$(( k * fact ))
fact=$((fact + 1 ))
done
echo "The Factorial is:" $k




# output

# Enter :
# 5
# The Factorial is: 120
