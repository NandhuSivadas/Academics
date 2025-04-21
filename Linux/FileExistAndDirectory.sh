read -p "Enter the file name: " file
if [ -e "$file" ]
then
    echo "File exists"
    if [ -z "$file" ]
    then
        echo "File is empty"
    else
        echo "File is not empty"
    fi
fi

if [ -d "$file" ]
then
    echo "it is directory"
else
    echo "it is not directory"
fi