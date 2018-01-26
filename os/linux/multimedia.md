# マルチメディアファイルの編集

## 音声ファイル関連

### 変換

```
in=in.mp3
out=out.wav
sox "${in}" "${out}"
```

### 連結

catだとビットレートが同じじゃないとダメなので、soxを使う

```
sox first.mp3 second.mp3 third.mp3 out.mp3
```

### flacを分割してmp3で出力 ({flac,cue} --> mp3..)

```
flac=foo.flac
cue=foo.cue
shnsplit -f "${cue}" -t %n.%t -o 'cust ext=mp3 lame -b 256 - %f' "${flac}.flv"
```
