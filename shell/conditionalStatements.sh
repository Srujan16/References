# !/bin/sh

echo -e "Enter file Path :\c"
read filePath

if [ -f $filePath ];then
	while read line
	do 
  	 echo $line
	done<$filePath
else
  	echo "Unable to locate file $filePath"
  
fi
