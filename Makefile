# ビルド(iOS)
ios-build:
	swift build -v

# 開発環境の整備(iOS)
ios-init:
	sh scripts/ios-init.sh

# テスト(iOS)
ios-tests:
	swift test -v

# Xcode の起動
launch-xcode:
	open Package.swift
