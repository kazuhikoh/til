# df

    dd [OPTIONS]

* バイナリレベルでデータをコピーするコマンド
* 用途
  * ディスクのバックアップ,復元
  * CD を iso にする
  * ディスクデータの完全削除
  
* Options

  |option  |desctiption|example|
  |:-------|:----------|:------|
  |if=FILE |stdinの代わりにファイルから読み込む (Input File)|`if=/path/to/image` `if=/dev/sdx`
  |of=FILE |stdoutの代わりにファイルに書き出す (Output File)|`of=/path/to/image` `of=/dev/sdx`
  |bs=BYTES|一度にBYTESずつ読み書きする|`bs=4M` (4MBずつ)|
  
## Backup,Restore

### disk <--> file

```
# backup
sudo dd bs=4M if=/dev/sdx of=/path/to/image
# restore
sudo dd bs=4M if=/path/to/image of=/dev/sdx
```
  
### disk <--> .gz
```
# backup
sudo dd bs=4M if=/dev/sdx | gzip > /path/to/image.gz
# restore
gzip -dc /path/to/image.gz | sudo dd bs=4M of=/dev/sdx
```
  
## CD --> .iso
```
dd if=/dev/cdrom of=/path/to/cd.iso bs=2048 conv=sync,notrunc
```
  
## Erase Disk
```
dd if=/dev/zero of=/dev/sdx
```
