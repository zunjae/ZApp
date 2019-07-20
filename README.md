# ZApp
Collection of App Utils

Add it in your root build.gradle at the end of repositories:

```java
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```


Add the dependency:

```java
dependencies {
    compile 'com.github.zunjae:Zapp:0.1'
}
```

Usage:

```java
boolean hasAppInstalled = AppUtil.hasAppInstalled(this, "com.zunjae.anyme"); // true | false

boolean hasAnyAppInstalled = AppUtil.hasAnyAppInstalled(this, "first.package", "second.package"); // true | false

String packageName = AppUtil.getAnyAppInstalled(this, "coolapp.pro", "coolapp.ad"); // "coolapp.pro" | "coolapp.ad" | null

boolean intentIsValid = AppUtil.intentIsValid(this, yourIntentHere); // true | false

boolean deviceIsEmulator = AppUtil.deviceIsEmulator(); // true | false

double versionNumberDouble = AppUtil.versionNumberDouble(); // 1.0 | 2.0 | -1.0

int versionNumberInt = AppUtil.versionNumberInt(); // 1 | 2 | -1

String versionNumberString = AppUtil.versionNumberString(); // "1" | "2" | null

```

Check https://github.com/zunjae/ZApp/blob/master/zapplib/src/androidTest/java/com/zunjae/zapplib/MainInstrumentationTest.java for example usage

## LICENSE

There's no license associated with this project. You may copy the code and modify it to your heart's content. You may not send me questions regarding this project. You're on your own.
