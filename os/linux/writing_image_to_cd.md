# CD/DVD に ディスクイメージを書き込む方法

## フォーマット

### CD
`cdrecord` でフォーマット
```
cdrecord dev=/dev/cdrom blank=fast
```

### 書き込み
`dd` で書き込む
```
dd if=image.iso of=/dev/cd bs=64k status=progress conv=fsync
sync
```

## 参考
* http://takuya-1st.hatenablog.jp/entry/20101025/1288002819
