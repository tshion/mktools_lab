#!/usr/bin/env ruby

# Git 履歴の変更があるかどうかの判定
# 更新がある場合は、バージョン文字列が出力される
#
# 注意事項
# * ".ruby-version" に記載されているバージョンで実行してください

require "date"

# 現在のブランチ情報
BRANCH_CURRENT = `git branch --contains | cut -d " " -f 2`
# puts "Current branch: #{BRANCH_CURRENT}"

# 最新タグの確認
latestTag = `git describe --tags --abbrev=0`
latestTag = latestTag.empty? ? "none" : latestTag
# puts "Latest tag: #{latestTag}"

# コミットタグ候補の生成
LATEST_COMMIT_DATE = DateTime.parse(`git log $(echo #{BRANCH_CURRENT}) -1 --date=iso-strict --format='%cd'`)
TAG_CANDIDATE = LATEST_COMMIT_DATE.strftime("%Y.%m.%d")
# puts "Tag candidate: #{TAG_CANDIDATE}"

# 更新がある場合は、バージョン文字列を出力する
if latestTag != TAG_CANDIDATE then
    puts TAG_CANDIDATE
end
