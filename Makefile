# ビルド(iOS)
ios-build:
	swift build -v

# テスト(iOS)
ios-tests:
	swift test -v

# Xcode の起動
launch-xcode:
	open Package.swift
