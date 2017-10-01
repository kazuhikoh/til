FreeNas 11.0-U4 Setup
================================

# Install

## InstallerのCD作成

CDをアンマウント
```
umount /mnt/cdrom
```

中身が入ってたので、CDをフォーマット
```
cdrecord dev=/dev/sr0 --blank=fast
```

iso書き込み
```
cdrecord FreeNAS-11.0-U4.iso
```

## USBにインストールして起動
ウィザードに從うだけで特に何もなくインストール完了。
再起動 -> BIOSでUSBを優先にする -> 起動

# Network
## Static IP

Console setup > `1) Configure Network Interface`

## DNS

Console setup > `6) Configure DNS`

|Input|`resolv.conf`|
|:----|:---|
|DNS Domain [xxx]:                   |search xxx|
|DNS Nameserver X [xxx.xxx.xxx.xxx]: |namerserver xxx|


* `resolv.conf` を確認すると、ちゃんと設定されてる
* `resolv.conf` に書いておいても再起動すると消される

## 無線LAN

Intel ワイヤレスアダプターのドライバが入っていないので、インストールする必要がある
* [インテル® ワイヤレス・アダプターの Linux* サポートについて](https://www.intel.co.jp/content/www/jp/ja/support/network-and-i-o/wireless-networking/000005511.html)
* 今回は `Intel Dual Band Wireless-AC 3160`

* [LinuxでインテルNUCの内臓Wifiが認識されない場合の対処](https://qiita.com/tanuki-project/items/aa31db3d9c9d90822bc7)
