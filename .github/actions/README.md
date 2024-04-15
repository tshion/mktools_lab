# .github/actions
よくあるGitHub Actions の実装レシピ

アクション名 | 実行環境 | 用途
--- | --- | ---
setup-git-with-github-actions-bot | bash | git config user にGitHub Actions Bot を設定する



## 利用方法
public リポジトリなので、アクセス権の設定無しに利用可能。

``` yaml
# (省略)
steps:
  # (省略)
  - name: Checkout github actions utility repository
    uses: actions/checkout@v4
    with:
      repository: tshion/mktools_lab
      sparse-checkout: .github/actions
  # (省略)
  - uses: ./.github/actions/???
  # (省略)
```



## 参考文献
* [GitHub Actionsの共通したアクションを切り出してシンプルに保つ](https://zenn.dev/stafes_blog/articles/ikkitang-a694b8afeb66f5)
