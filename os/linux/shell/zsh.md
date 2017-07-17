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

## Prompt

`PROMPT`, `RPROMPT` を設定することで変更できる

### 色をつける

プロンプト書式でのみ使える構文がある
* `%F{color}text%f`: 前景色を指定
* `%B{color}text%b`: 背景色を指定
* `color` に指定できる色は↓
  * https://wiki.archlinux.org/index.php/zsh#Colors

### 直前に実行したコマンドの exitcode によって切り替える

こんなかんじで設定できる
```
# (⊃＾ω＾)⊃ を 正常終了=>黄 異常終了=>赤 で表示
PROMPT='%(?.%F{yellow}(⊃＾ω＾)⊃%f.%F{red}(⊃＾ω＾%)⊃%f) '
```

* `%(x.true-text.false-text)`
  * [Conditional Substrings in Prompts](http://zsh.sourceforge.net/Doc/Release/Prompt-Expansion.html#Conditional-Substrings-in-Prompts)
  * 区切り文字は `.` でなくても 任意文字が使える
  * `false-text` に `)` を入れる場合は `%)` と書く
