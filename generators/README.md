# generators
設定値から各言語向けにコード生成していくプロジェクト。

プロジェクト | 用途
--- | ---
[GenerateCodeLibrary](./GenerateCodeLibrary/) | コード生成関連の共通ライブラリ
[GenerateCodeLibraryTest](./GenerateCodeLibraryTest/) | コード生成関連の共通ライブラリのテスト
[HttpRequestHeaderCodeGenerator](./HttpRequestHeaderCodeGenerator/) | HTTP Request Header のコード生成
[HttpResponseHeaderCodeGenerator](./HttpResponseHeaderCodeGenerator/) | HTTP Response Header のコード生成
[HttpStatusCodeGenerator](./HttpStatusCodeGenerator/) | HTTP Status Code のコード生成


## メモ
### 展開データとプレースホルダー
展開するデータ | 設定できるデータ数 | プレースホルダー | 出現位置 | 備考
--- | :---: | --- | --- | ---
クラスのドキュメントコメント | 1 | %%CLASS_DOCS%% | ブロック | 各行に分解してから設定する
クラス名 | 1 | %%CLASS_NAME%% | インライン | 特になし
クラスが継承している型 | 1 | %%CLASS_TYPE_BASE%% | インライン | 特になし
プロパティのドキュメントコメント | 複数 | %%PROPERTY_DOCS%% | ブロック | 各行に分解してから設定する
プロパティ名 | 複数 | %%PROPERTY_NAME%% | インライン | 特になし
プロパティ宣言の前につける追記事項 | 複数 | %%PROPERTY_PREFIX%% | ブロック | 各行に分解してから設定する
プロパティの型名 | 複数 | %%PROPERTY_TYPE%% | インライン | 特になし
プロパティの値 | 複数 | %%PROPERTY_VALUE%% | インライン | 特になし
(なし) | 0 | %%REPEAT_BEGIN%% | ブロック | 反復範囲の開始<br />プレースホルダー左側のインデントをチェックし、反復要素に適用する
(なし) | 0 | %%REPEAT_END%% | ブロック | 反復範囲の終了
