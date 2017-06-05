cd /opt/sophos-av

sh uninstall.sh

#Sophos-Installation

apt-get install cifs-utils
mkdir /mnt/sophosupdate
chmod 755 /mnt/sophosupdate
mount -t cifs //192.168.2.35/sophosupdate /mnt/sophosupdate -o username=administrator,password=Pramati@123

cd /mnt/sophosupdate/CIDs/S000/savlinux

ls -l

sh install.sh

#Package Update


/opt/sophos-av/bin/savsetup


/opt/sophos-av/bin/savupdate

apt-get update
