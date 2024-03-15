#!/usr/bin/env ruby

# アプリバージョンの更新
#
# 注意事項
# * ".ruby-version" に記載されているバージョンで実行してください

require 'pathname'

# 作業対象ファイルの設定と検証
PATH = Pathname.new(__dir__).join("../variables.gradle")
unless FileTest.exist?(PATH) then
    puts("#{PATH} にファイルが存在しません")
    exit 1
end

# コマンドライン引数の検証
unless ARGV.length == 1 then
    puts("None update!")
    exit
end

TAG = ARGV[0]
unless /^\d{4,}\.\d{2}.\d{2}$/.match?(TAG) then
    puts("書式に則ったバージョン文字列を指定してください")
    exit 1
end

# バージョン情報の算出
TOKENS = TAG.split('.')
VERSION_CODE = TOKENS[0].to_i * 10000 + TOKENS[1].to_i * 100 + TOKENS[2].to_i
VERSION_NAME = TAG

# ファイル出力
text = ""
File.open(PATH, "r") { |file|
    text = file.read
}
text = text.gsub(/^( *appVersionCode = )\d+$/) { "#{$1}#{VERSION_CODE}" }
text = text.gsub(/^( *appVersionName = ')\d{4,}\.\d{2}\.\d{2}(')$/) { "#{$1}#{VERSION_NAME}#{$2}" }
File.open(PATH, "w") { |file|
    file.write(text)
}

# 終了表示
puts("Set code: #{VERSION_CODE}, name: #{VERSION_NAME}")
