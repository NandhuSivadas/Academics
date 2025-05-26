read -p "Enter?:" num
temp=$num
arm=0
while [ $num -ne 0 ]
do
  k=$(( num % 10 ))
  b=$(( k * k * k ))
  arm=$(( arm + b ))
  num=$(( num / 10 ))
done
echo $temp
echo $arm
if [ $temp -eq $arm ]
then 
 echo "Armstrong number"
else
  echo "Not Armstrong"
fi
