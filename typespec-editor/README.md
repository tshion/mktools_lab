# TypeSpec Editor
TypeSpec で定義したデータを入力できるUI の実装。



## Notes
### 対応表
TypeSpec | 入力欄
--- | ---
`argb` ※ | `input:text` + `pattern:^#[\dA-F]{8}$`
`boolean` | `input:checkbox`
`float` | `input:text` + `pattern:^\d+\.\d+$`
`integer` | `input:num` + ( `min` + `max` )
`integer \| integer` | `select`
`latitude` ※ | `input:number` + `min:-90.0` + `max:90.0` + `step:0.000001`
`longitude` ※ | `input:number` + `min:-180.0` + `max:180.0` + `step:0.000001`
`rgb` ※ | `input:color`
`string` | `input:text`
`string \| string` | `select`
`url` | `input:url`

### 生成コマンド
``` shell
npx -p @angular/cli@latest ng new typespec-editor --minimal --package-manager npm --routing --skip-git --skip-install --standalone --style css
```
