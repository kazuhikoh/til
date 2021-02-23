# FFmpeg (https://www.ffmpeg.org/)

## Usage

### 変換

mpg (mpeg2video + mp2) -> mp4
```
ffmpeg -i in.mpg -strict -2 -movflags faststart -vcodec libx264 -acodec aac out.mp4
```

### 切り取り

開始10秒 から 20秒間 を切り取る
```
ffmpeg -ss 10 -i in.mp4 -t 20 out.mp4
```

開始10.5秒 から 10分間 を切り取る (hh:mm:ss.SSS の形式でも指定できる)
```
ffmpeg -ss 00:00:10.500 -i in.mp4 -t 00:10:00 out.mp4
```

* `-ss` は `-i` の前に置かないと、めちゃくちゃ遅くなるので注意

### 音声 と 画像 から 動画 を作成

(jpg, mp3) -> mp4
```
ffmpeg -loop 1 -r 30000/1001 -i cover.jpg -i voice.mp3 -vcodec libx264 -acodec aac -strict experimental -ab 320k -ac 2 -ar 48000 -pix_fmt yuv420p -shortest out.mp4
```

### ダウンロード

`-i` に URL を指定して、保存することもできる.
```
ffmpeg -i http://piyopiyo.com/piyo.m3u8 out.ts
```

## Option

### Basic
|option|value|note|
|:--|:--|:--|
|-i|FILEPATH<br>URL|**i**nput|
|-f|mp4, flv, ...|**f**ormat<br>なければ出力ファイルの拡張子から判断してくれてる気がする|

### Audio
|option|value|note|
|:--|:--|:--|
|-acodec|aac|**a**udio **codec**|
|-ar|48000<br>41000|**a**udio sampling **r**ate|
|-b:a|256k (単位をつけられる)|**b**itrate of **a**udio|

### Video
|option|value|note|
|:--|:--|:--|
|-vcodec|libx264|**v**ideo **codec**|

### Metadata

|option|value|note|
|:--|:--|:--|
|-movflags|faststart|メタデータをファイルの先頭に移動させるオプション<br>mp4形式の動画を再生するためにはメタデータ情報が必要 <br>メタデータは通常ファイルの末尾に付与される<br>先頭に書いておくことで、ファイルサイズが大きい動画でもすぐに再生開始可能<br>ストリーミング再生させる場合にも必要

### Others

|option|value|note|
|:--|:--|:--|
|-strict|-2<br>or<br>-experimental|`-acodec acc`を指定するときに必要(ffmpeg2.8)|

## References
* [FFmpegことはじめ](https://qiita.com/okamos/items/684c59928dbe9bf9bbcd)
* [動画処理の定番ツール「FFmpeg」ことはじめ](https://qiita.com/kitar/items/59f80bba2ca997e0f5e6)
