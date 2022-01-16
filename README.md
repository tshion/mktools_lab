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
### ライブラリバージョン
セマンティックバージョニングに従います。
Swift Package の都合上、Git タグは数字とピリオドのみで命名してください。
