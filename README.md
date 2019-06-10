# mcupdate
Old Minecraft News blog, updated for recent Minecraft versions + companion launcher modification

# Installation
1. Install Java 8 if not already installed
2. Download the launcher bootstrap from Mojang's S3: http://s3.amazonaws.com/Minecraft.Download/launcher/Minecraft.jar
3. Run `Minecraft.jar`, then close the launcher when it loads
4. Open `launcher.jar` inside the `.minecraft` folder with an archive tool
5. Drag the `net` folder from `Release.zip` into launcher.jar
6. Delete `MOJANGCS.RSA` and `MOJANGCS.SF` from the `META-INF` folder inside launcher.jar

# Usage
You MUST open launcher.jar directly from now on!
Using the bootstrap will replace the modified launcher with the original one.

I reccommend creating a shortcut on the desktop that runs the following command

`java.exe -jar %appdata%\.minecraft\launcher.jar`

I don't care enough to explain it for Linux but if you use Linux you should know what to do.
