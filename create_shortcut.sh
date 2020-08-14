#!/bin/bash

owd=$(pwd)
mkdir ~/.minecraft
cd ~/.minecraft
wget https://github.com/Lesking72/mcupdate/raw/master/icon.png
wget https://github.com/Lesking72/mcupdate/releases/download/1.3/launcher.jar

cd ~/Desktop

echo [Desktop Entry] > Minecraft\ Launcher.desktop
echo Type=Application >> Minecraft\ Launcher.desktop
echo Name=Minecraft Launcher >> Minecraft\ Launcher.desktop
echo Exec=java -jar ~/.minecraft/Minecraft.jar >> Minecraft\ Launcher.desktop
echo Icon=~/.minecraft/icon.png >> Minecraft\ Launcher.desktop
echo Terminal=false >> Minecraft\ Launcher.desktop
chmod +x Minecraft\ Launcher.desktop

cd $owd


