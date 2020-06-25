This decompiled source is based on launcher version 1.6.93
To compile the classes, run `javac <source.java> -cp path_to_original.jar` for each .java file
And then just stick the compiled classes into the original launcher.jar

There's probably a better way to automate that but I don't know and am currently too lazy to learn

`migrateOldAssets()` is currently broken due to compiler errors at line 334 in `MinecraftGameRunner.java`
If you fix it please let me know. It might be as simple as using a different decompiler, or probably something else simple but I don't know enough about Java to fix it.

`LauncherConstants.java` didn't need to be modified in practice (the blog window is pointed to its domain in `LauncherPanel.java`)
but I'm figuring that there must be some reason for it, and since I'm already changing 4 classes I might as well change 5, and I was able to stick
a version number in there, for what it's worth.

(the default JVM args are also in multiple classes, not sure why)

The original launcher.jar is available from https://launcher.mojang.com/v1/objects/eabbff5ff8e21250e33670924a0c5e38f47c840b/launcher.jar