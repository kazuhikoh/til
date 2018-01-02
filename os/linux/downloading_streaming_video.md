ストリーミング動画 の ダウンロード方法
================================

## [ニコニコ動画](http://www.nicovideo.jp/)

### タイムシフト
```
rtmpdump -V -r $RTMP_URL -y mp4:$CONTENT -C S:$TICKET -o out.flv
```
パラメータには、↓から取得したXMLの値を指定する。
```
http://watch.live.nicovideo.jp/api/getplayerstatus?v=lv000000000
```
* ブラウザからニコニコ動画 にログインした後にアクセス
* `lv000000000` の部分は、ダウンロードしたい動画のパスに合わせる

|PARAMETER|XPATH|
|:--|:--|
|RTMP_URL| `//getplayerstatus/rtmp/url/text()` |
|TICKET  | `//getplayerstatus/rtmp/ticket/text()` |
|CONTENT | `//getplayerstatus/stream/quesheet/que/text()` の中の、<br>`/content/.*\.f4v` の部分 |

## [エムキャス](mcas.jp)

### TOKYO MX 1
```
ffmpeg -strict -2 -i https://movie.mcas.jp/switcher/smil:mcas1.smil/chunklist_b1800000.m3u8 out.ts
```

|URL|Description|
|:--|:--|
|https://movie.mcas.jp/switcher/smil:mcas1.smil/master.m3u8?Expires=*&Signature=*&Key-Pair-Id=*|マスタインデックスファイル|
|https://movie.mcas.jp/switcher/smil:mcas1.smil/chunklist_b1800000.m3u8<br>https://movie.mcas.jp/switcher/smil:mcas1.smil/chunklist_b1000000.m3u8<br>https://movie.mcas.jp/switcher/smil:mcas1.smil/chunklist_b600000.m3u8<br>https://movie.mcas.jp/switcher/smil:mcas1.smil/chunklist_b180000.m3u8|プレイリストファイル|

## [OPENREC](https://www.openrec.tv)
```
ffmpeg -i $URL out.flv
```

URL は Google Chrome Developer Tool を使って確認する `.m3u8` ファイルのURLを調べる
  * Network> Filtering by 'm3u8'

生放送の番組

|URL|Description|
|:--|:--|
|normal.m3u8|マスタインデックスファイル |
|chunklist_high/chunklist.m3u8<br>chunklist_medium/chunklist.m3u8<br>chunklist_low/chunklist.m3u8|プレイリストファイル|
生放送じゃない番組

|URL|Description|
|:--|:--|
|index.m3u8|マスタインデックスファイル |
|2000kbps.m3u8<br>1000kbps.m3u8<br>500kbps.m3u8<br>250kbps.m3u8|プレイリストファイル|
