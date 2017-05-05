# VLC Media Player

[the best Open Source player - VideoLAN](http://www.videolan.org/vlc/)

# Snapshot

* 保存ファイル名に動画の情報とかを入れるには
  * Simple Preferences > Video : Video snapshot
    * ファイル名は {prefix}{numbering}.{format} となる
    
      |TERM     |DESCRIPTION|
      |:--------|:----------|
      |prefix   |固定でつける文字列.<br>用意された変数を使うこともできる.<br>[Documentation:Format String](https://wiki.videolan.org/index.php?title=Documentation:Format_String&oldid=26201)|
      |numbering|現在日時 (ex: 2017-01-01-00h00m00s000)<br>or<br>連番 (ex: 00001)|
      |format   |拡張子|
      
    * 例) filename=foo.mp4, prefix="$t-$D-", format=png --> foo-00_23_41-00001.png
      
