CapsLock を Ctrl にする
========

これやってから、再ログインする
```
dconf reset /org/gnome/settings-daemon/plugins/keyboard/active
dconf write /org/gnome/desktop/input-sources/xkb-options "['ctrl:nocaps']"
```

参考
--------
* [UbuntuTips/Desktop/HowToSetCapsLockAsCtrl - Ubuntu Japanese Wiki](https://wiki.ubuntulinux.jp/UbuntuTips/Desktop/HowToSetCapsLockAsCtrl)

