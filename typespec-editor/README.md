# TypeSpec Editor
TypeSpec で定義したデータを入力できるUI の実装。



## Notes
### 対応表
TypeSpec | 入力欄
--- | ---
`boolean` | `select`
`float` | `input:num`
`integer` | `input:num`
`string` | `input:text`
`"literal1" \| "literal2"` | `select`

### 生成コマンド
``` shell
npx -p @angular/cli@latest ng new typespec-editor --minimal --package-manager npm --routing --skip-git --skip-install --standalone --style css
```
