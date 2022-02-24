# mktools_ios
## 導入方法 [![GitHub tag (latest by date)](https://img.shields.io/github/v/tag/tshion/mktools_lab)](https://github.com/tshion/mktools_lab/tags)
Swift Package Manager 経由で導入出来ます。
Package.swift に下記を記述してください。

``` swift
let package = Package(
    dependencies: [
        .package(
            url: "https://github.com/tshion/mktools-lab",
            .exact("(tag name)")
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

[XcodeGen](https://github.com/yonaskolb/XcodeGen) を使っている場合は、下記の記述をしてください。
``` yaml
packages:
  mktools_ios:
    github: tshion/mktools_lab
    version: (tag name)

targets:
  (Target Name):
    dependencies:
      - package: mktools_ios
```
