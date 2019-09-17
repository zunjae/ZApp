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
    compile 'com.github.zunjae:Zapp:0.6'
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

## License

This project is available under the MIT license, though there is no need to include a license and copyright notice
