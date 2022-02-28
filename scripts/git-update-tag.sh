#!/bin/bash

# 現在のブランチの出力
currentBranch=$(git branch --contains | cut -d " " -f 2)
echo "Current branch: $currentBranch"

# 最新コミット日時の出力
echo "Latest commit date: $(git log $currentBranch -1 --date=iso-strict --format='%cd')"

# 最新タグの確認
latestTag=$(git describe --tags --abbrev=0)
latestTag=${latestTag:-'none'}
echo "Latest tag: $latestTag"

# コミットタグ候補の生成
tmpTagMajor=$(git log $currentBranch -1 --date=format-local:'%Y' --format='%cd')
tmpTagMinor=$(git log $currentBranch -1 --date=format-local:'%m' --format='%cd')
tmpTagRevision=$(git log $currentBranch -1 --date=format-local:'%d' --format='%cd')
tmpTag="$tmpTagMajor.$tmpTagMinor.$tmpTagRevision"
echo "Tag candidate: $tmpTag"

# 更新があるかどうかの判定
if [ "$latestTag" = "$tmpTag" ]
then
    echo "None update!"
    exit 0
fi

# ファイルに記述されているライブラリバージョンの更新
pathAndroid='../variables.gradle'
sed -i '' "s/appVersionMajor = [0-9]\{1,\}/appVersionMajor = $tmpTagMajor/" $pathAndroid
sed -i '' "s/appVersionMinor = [0-9]\{1,\}/appVersionMinor = $tmpTagMinor/" $pathAndroid
sed -i '' "s/appVersionRevision = [0-9]\{1,\}/appVersionRevision = $tmpTagRevision/" $pathAndroid

echo "Update version in files."

# Git 更新
git add $pathAndroid
git commit -m "Update Version"
git pull
git push origin
echo "Push files updated version text."

# Git タグの付与
git tag $tmpTag
git push origin $tmpTag
echo "Add tag!"
