FROM ubuntu:20.04

# 作業フォルダーのマウントポイントの設定
VOLUME [ "/home/worker" ]

# 実行コマンドの設定
ENTRYPOINT [ "/bin/sh" ]

# パッケージ整備
RUN apt-get -y update && apt-get install -y git && apt-get install -y make

# 作業フォルダーに変更
WORKDIR /home/worker
