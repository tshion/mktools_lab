# mktools_android
## 導入方法 [![Release](https://jitpack.io/v/tshion/mktools_lab.svg)](https://jitpack.io/#tshion/mktools_lab)
[JitPack](https://jitpack.io/) 経由で導入出来ます。

Android Gradle Plugin のバージョンが7.x 以上の場合は、
ルートのsettings.gradle に下記を記述してください。

``` gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...

        maven { url 'https://jitpack.io' } // <- Add Line
    }
}
```

そのあとで適用したいモジュールで依存関係を追加してください。

``` gradle
dependencies {
    ...
    implementation 'com.github.tshion:mktools_lab:(tag name)' // <- Add Line
    ...
}
```
