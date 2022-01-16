#!/bin/sh

# シェルの確認
if [ "$SHELL" = '/bin/bash' ] || [ "$SHELL" = '/usr/local/bin/bash' ]; then
    SHELL_RESOURCE=~/.bashrc
elif [ "$SHELL" = '/bin/zsh' ] || [ "$SHELL" = '/usr/local/bin/zsh' ]; then
    SHELL_RESOURCE=~/.zshrc
else
    echo "Unsupported shell: ${SHELL}"
    exit 1
fi


# コードフォーマットの実行
mint run mint run swiftformat "$1/Sources" --verbose
mint run mint run swiftformat "$1/Tests" --verbose
