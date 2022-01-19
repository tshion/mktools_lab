# mktools_lab
自作ライブラリの試作環境

対象の実行環境 | ライブラリ名 | 備考
--- | --- | ---
[Android](./android) | mktools_android | Android 用ライブラリの試作環境
[iOS](./ios) | mktools_ios | iOS 用ライブラリの試作環境


## 開発環境の準備
### Android
Android Studio を利用して開発してください。

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
## ファイル書式
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

※Swift Package の都合上、Git タグは数字とピリオドのみで命名しています
