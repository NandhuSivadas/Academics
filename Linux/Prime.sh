read -p "Enter the number:" num
i=2
flag=0
while [ $i -lt $num ]
do
k=$((num % i))
if [ $k -eq 0 ]
then
flag=1
fi
i=$((i+1))
done
if [ $flag -eq 1 ]
then 
echo "not prime"
else
echo " prime"
fi

# output


# Enter the number:4
# not prime
