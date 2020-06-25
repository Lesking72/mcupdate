# mcupdate
Old Minecraft News blog, updated for recent Minecraft versions + companion launcher modification

# Requirements
Java 8 or later (available from https://adoptopenjdk.net/ or from Oracle)

# Usage
If you still have the old launcher bootstrap, you must delete it or it will redownload the original launcher.

Put launcher.jar in your .minecraft folder and create a shortcut to launch it

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Command line for Windows:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`javaw.exe -jar %appdata%\.minecraft\launcher.jar`

If you use Java 11 or newer, you'll need to set these JVM arguments in the launcher.
(The latest version of the mod applies these arguments automatically)

`-Xmx2G -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32M`
