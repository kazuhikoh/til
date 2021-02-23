# mktemp
一時保存に使うファイル,ディレクトリを作成する

## 書式
```
mktemp [OPTION]... [TEMPLATE]
```

## 実行例

一時ファイルを作成して、コマンド終了時に削除
```
readonly TEMP=$(mktemp)

trap "
rm $TEMP
" 0
```

`TEMPLATE` で、一時ファイル名を指定できる
```
mktemp foo.XXX
```
* 最後に連続した 'X' を最低 3個 含む文字列を指定しなければならない
  * 'X' の部分をランダムな文字に置き換えたものが ファイル名として使用される
* 指定しない場合は `tmp.XXXXXXXXXX` が使用される

`-p|--tmpdir` で、生成先ディレクトリを指定できる
```
mktemp -p path/to/temp
```
* 指定しない場合は `$TMPDIR` || `/tmp` が使用される

参考
* https://linuxjm.osdn.jp/html/GNU_coreutils/man1/mktemp.1.html
