# Desktop Shortcut

## 自分でインストール/ビルドしたアプリを、Launcherに表示されるようにする

### Create *.desktop
*  記述例
```
[Desktop Entry]
Name=Atom
Comment=A hackable text editor for the 21st Century.
GenericName=Text Editor
Exec=/usr/share/atom/atom %F
Icon=atom
Type=Application
StartupNotify=true
Categories=GNOME;GTK;Utility;TextEditor;Development;
MimeType=text/plain;
```

### Place

* 作成した *.desktop を次のいずれかに配置する

| dirpath | desctiption |
| :------ | :---------- |
| /usr/share/applications | システムで共通 |
| ~/.local/share/applications | ユーザごと? |

### Reload

```
desktop-file-install xxx.desktop
```

## References

* [デスクトップエントリ - ArchWiki](https://wiki.archlinuxjp.org/index.php/%E3%83%87%E3%82%B9%E3%82%AF%E3%83%88%E3%83%83%E3%83%97%E3%82%A8%E3%83%B3%E3%83%88%E3%83%AA)
* [Unityランチャーに自分でインストール/ビルドしたアプリケーションを登録する](http://d.hatena.ne.jp/reppets/20111109/1320846292)
