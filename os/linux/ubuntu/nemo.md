# Nemo

* Linux Mint の開発者によって、Nautilus を Fork して作られたファイラー
* https://github.com/linuxmint/nemo

## 便利な所

* ファイルパス入力欄がある
  * 意外とパンくずリスト表示だけなものが多い
* コンソールを開ける
* rootとして実行 ができる
* 2ペイン表示ができる(`F3`)
* sftpクライアントとして使える
  * パス欄に `ssh://USER@IPADDR[:PORT]` と入力すればいける

## Setup

### インストール
```
sudo add-apt-repository ppa:webupd8team/nemo
sudo apt-get update
sudo apt-get install nemo
```

* 拡張機能もある (nemo-*)
  
  ```
  sudo apt-get install nemo-dropbox nemo-emblems nemo-folder-color
  ```

### デフォルトのファイラとして設定
```
xdg-mime default nemo.desktop inode/directory application/x-gnome-saved-search
gsettings set org.gnome.desktop.background show-desktop-icons false
gsettings set org.nemo.desktop show-desktop-icons true
```
