# mktools_ios
## インストール方法
Swift Package Manager 経由でインストール出来ます。
Package.swift に下記を記述してください。

``` swift
let package = Package(
    dependencies: [
        .package(
            url: "https://github.com/tshion/mktools-lab",
            branch: "main"
        ),
    ],
    targets: [
        .target(
            name: "<your-target-name>",
            dependencies: [
                "mktools_ios"
            ]
        ),
    ]
)
```

XcodeGen を使っている場合は、下記の記述をしてください。
``` yaml
packages:
  mktools_ios:
    github: tshion/mktools_lab
    branch: main

targets:
  (Target Name):
    dependencies:
      - package: mktools_ios
```
