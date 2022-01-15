# mktools_lab
自作ライブラリの試作環境

対象の実行環境 | ライブラリ名 | 備考
--- | --- | ---
[Android](./android) | mktools_android | Android 用ライブラリの試作環境
[iOS](./ios) | mktools_ios | iOS 用ライブラリの試作環境


## 開発環境の準備
コマンド or ツール | 必須 or 任意 | 備考
--- | :---: | ---
```make``` | 任意 | [Makefile](./Makefile) の内容が使えるようになる
Visual Studio Code | 任意 | [tasks.json](./.vscode/tasks.json) の内容が使えるようになる
Xcode | 任意 | iOS 用ライブラリの開発時に役立つかも


## 開発ルール
### ライブラリバージョン
セマンティックバージョニングに従う。
Swift Package の都合上、Git タグは数字とピリオドのみで命名する。
