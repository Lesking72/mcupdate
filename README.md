# mcupdate
Old Minecraft News blog, updated for recent Minecraft versions + companion launcher modification

# Installation
1. Install Java 8 if not already installed (available from https://adoptopenjdk.net/ or from Oracle)
2. Download the latest launcher.jar from Mojang: https://launcher.mojang.com/v1/objects/eabbff5ff8e21250e33670924a0c5e38f47c840b/launcher.jar
3. Open launcher.jar with an archive tool
4. Copy the `net` folder from `Release.zip` into `launcher.jar`

# Usage
If you still have the old launcher bootstrap, you must delete it or it will redownload the original launcher.

I reccommend creating a shortcut on the desktop that runs the following command
`javaw.exe -jar %appdata%\.minecraft\launcher.jar`
If you're using Linux you either know what to do or can google it and if you're using a mac, God help you.

If you are using a later version of Java, the game will not launch with the default arguments. These are the defaults from the new launcher.
`-Xmx2G -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32M`
