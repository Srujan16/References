#!/bin/sh 

echo "Enter file path"
read path
while read line
do
	echo $line
done<$path
