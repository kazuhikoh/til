# Zsh

* [Zsh](http://www.zsh.org/)

## Setting files

* [zshの設定ファイルの読み込み順序と使い方Tipsまとめ - Qiita](http://qiita.com/muran001/items/7b104d33f5ea3f75353f)

| filepath      | 読み込まれる時 |
| :------------ | :---------- |
| /etc/zshenv   | いつも |
| ~/.zshenv     |  |
| /etc/zprofile | ログインシェル起動時 |
| ~/zprofile    | ログインシェル起動時 |
| /etc/zshrc    | ログインシェル起動時,インタラクティブシェル起動時 |
| ~/.zshrc      | ログインシェル起動時,インタラクティブシェル起動時 |
| /etc/zlogin   | ログインシェル起動時(zshrcの後) |
| ~/.zlogin     | ログインシェル起動時(zshrcの後) |
