# mktools_android
## インストール方法
[JitPack](https://jitpack.io/) からインストールできます。

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
    implementation 'com.github.tshion.mktools_lab:mktools_android:main-SNAPSHOT'
    ...
}
```
