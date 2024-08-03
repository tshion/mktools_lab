# ビルド(iOS)
ios-build:
	sh scripts/ios-format.sh "./ios"
	swift build -v

# 開発環境の整備(iOS)
ios-init:
	sh scripts/ios-init.sh

# テスト(iOS)
ios-tests:
	sh scripts/ios-format.sh "./ios"
	swift test -v

# Xcode の起動
launch-xcode:
	open Package.swift

# TypeSpec をHTML へ変換
.PHONY: typespec-to-html
typespec-to-html:
	npx tsp compile ./typespec
	node ./typespec-to-html/index.js
	@echo finish $@.
