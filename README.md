# mktools_lab
自作ライブラリの試作環境

プロジェクト | 入手先 | 対象環境 | 備考
--- | :---: | --- | ---
([.github/actions](./.github/actions/)) | N/A | N/A | よくあるGitHub Actions の実装レシピ
([generators](./generators/)) | N/A | (macOS, Windows) | コード自動生成ツール群
[mktools_android](./android/) | [![Release](https://jitpack.io/v/tshion/mktools_lab.svg)](https://jitpack.io/#tshion/mktools_lab) | Android | Android 用ライブラリの試作環境
[mktools_ios](./ios/) | SwiftPM<br />[![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/tshion/mktools_lab)](https://github.com/tshion/mktools_lab/tags) | iOS | iOS 用ライブラリの試作環境
([mktools_jvm_sample](./jvm_sample/)) | N/A | (macOS, Windows) | Java, Kotlin 文法の試し書き環境

※バッジ表記：[Shields.io](https://shields.io/)


## 開発環境の準備
### Android
Android Studio Bumblebee 以降を利用して開発してください。

### C#(generators)
Visual Studio 2022 以降を利用して開発してください。

### iOS
下記が使える状態で```make ios-init``` を実行してください。

* ```bash``` or ```zsh```
* ```git```
* ```make```
* ```swift```

開発作業はコマンドラインでのビルドがベースのため、[Makefile](./Makefile) 内の定義を適宜利用してみてください。

エディター | 備考
--- | ---
Visual Studio Code | [tasks.json](./.vscode/tasks.json) 内にあるタスクが利用できます
Xcode | Build のPre Action 等を設定していないので、適宜コマンドを実行してください


## 開発ルール
### Android
* [Android API Guidelines](https://android.googlesource.com/platform/developers/docs/+/refs/heads/master/api-guidelines/index.md)
* [Android Developers](https://developer.android.com/)
* [AOSP Java Code Style for Contributors | Android Open Source Project](https://source.android.com/setup/contribute/code-style)
* [Document Kotlin code: KDoc and Dokka | Kotlin](https://kotlinlang.org/docs/kotlin-doc.html)
* [Kotlin Docs | Kotlin](https://kotlinlang.org/docs/home.html)

### ファイル書式
全体のルールは[.editorconfig](./.editorconfig) をご覧ください。

項目 | 設定内容
--- | ---
インデント | 4つ分のスペース(一部例外あり)
空白文字 | 文末のものは削除(一部例外あり)
ファイル末尾 | 改行を追加する(一部例外あり)
文字コード | UTF-8

### ライブラリバージョン(Git タグ)
main ブランチの最新コミットの日付を、セマンティックバージョニングに従った下記形式で命名していきます。
毎日、ビルドが成功するかどうかに関わらず、GitHub Actions を用いて自動付与します。

```
yyyy.MM.dd # 例)2015.04.01
```

#### 備考
* Swift Package の都合上、Git タグは数字とピリオドのみで命名しています
* 外部サービス(JitPack, Swift Package) はGit タグベースで判断しているため、ソースコード内のバージョンと一致しません
