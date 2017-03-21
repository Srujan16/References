#!/bin/sh

echo -e "enter pattern : \c"
read pattern
echo -e "enter filePath : \c"
read filePath
echo "Searching for pattern $pattern in file $filePath"
echo -e "Result : \n"
grep $pattern  $filePath
