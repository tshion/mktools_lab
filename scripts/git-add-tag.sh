#!/bin/sh

# 最新タグの確認
latestTag=$(git describe --tags --abbrev=0)
latestTag=${latestTag:-'none'}
echo "Latest tag: $latestTag"

# コミットタグ候補の生成
tmpTag=$(git log main -1 --date=format-local:'%Y.%m.%d' --format='%cd')
echo "Tag candidate: $tmpTag"

# タグの付与
if [ "$latestTag" != "$tmpTag" ]; then
    git tag $tmpTag
    git push origin $tmpTag
    echo "Add tag!"
else
    echo "None update!"
fi
