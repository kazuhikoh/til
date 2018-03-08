# YAMAHA's routers

|Image|Name|Note|
|:---|:---|:---|
|<img src="https://network.yamaha.com/var/site/storage/images/_aliases/size_large/8/5/9/8/18958-5-jpn-JP/rtx810_main.jpg" height="100px">|[ギガアクセスVPNルータ－ RTX810](https://network.yamaha.com/products/routers/rtx810/index)|ポート: lan1.1-4, wan<br>(WANを挿すポートが決まってる)<br>WebGUIがくそ|
|<img src="https://network.yamaha.com/var/site/storage/images/_aliases/size_large/1/8/8/8/18881-4-jpn-JP/rtx1210_main.jpg" height="100px">|[ギガアクセスVPNルーター RTX1210](https://network.yamaha.com/products/routers/rtx1210/index)|ポート: lan1.1-8, lan2, lan3|

[ここ](http://www.rtpro.yamaha.co.jp/RT/manual.html)からマニュアルがDLできる。

設定は [コマンド](http://www.rtpro.yamaha.co.jp/RT/manual/rt-common/index.html) or [WebGUI](http://192.168.100.1) で。

# 設定方法

## WebGUI

ルータのIPアドレスと クライアントのセグメントをあわせて、ブラウザからアクセス
* 工場出荷時状態だと lan1 が `192.168.100.1` になっている

## USBメモリ

1. `/config.txt` にコマンドを記述
1. USBポートに挿入
1. 音がなる(ぶひぶひ)
1. USBポート横のボタン と DOWNLOADボタン を同時に押しっぱなし
1. 音がなる(ぶ)
1. ルータが再起動する(全てのランプが一斉に点灯する)
1. USBメモリを抜く

# IPアドレス割当

```
ip lan1 address 192.168.10.1/24
```

DHCPを有効にするには
```
dhcp service server
dhcp server rfc2131 compliant except remain-silent
dhcp scope 1 192.168.10.100-192.168.10.254/24
```
* lan に割り当てたIPと 同じセグメントで `dhcp scope` をつくっておけば、IPが振られる

# デフォルトゲートウェイ

```
ip route default gateway 10.1.1.1
```

# ルーティング

静的ルーティング
```
ip route 192.168.10.1/24 gateway 172.16.10.1
```

# NAPT (IPマスカレード)

NATディスクリプタを定義 (No=1, Type=NAPT, 外側=primary, 内側=auto)
```
nat descriptor type 1 masquerade
nat descriptor address outer 1 primary
nat descriptor masquerade incoming 1 reject
```

Interface に紐付け (lan2 の in/out で有効にする)
```
ip lan2 nat descriptor 1
```

# VLAN

VLAN を有効にするにはこれ
```
lan type lan1 port-based-option=divide-network
# Rev.10.01 系以前のファームウェアでは
# lan type lan1 port-based-ks8995m=divide-network
```

物理ポート と VLAN の紐付け
```
vlan port mapping lan1.1 vlan1
vlan port mapping lan1.2 vlan1
vlan port mapping lan1.3 vlan1
vlan port mapping lan1.4 vlan1
vlan port mapping lan1.5 vlan2
vlan port mapping lan1.6 vlan2
vlan port mapping lan1.7 vlan2
vlan port mapping lan1.8 vlan2
```

VLAN に IPアドレス を割り当てる
```
ip vlan1 address 192.168.0.1/24
```

# NTP サーバ

```
ntpdate ntp.tut.ac.jp
```

NTPサーバ一覧
* [日本の 一次 NTP サーバー](http://www.redout.net/data/ntp.html)
* [NTP サーバ 一覧](http://www.venus.dti.ne.jp/~yoshi-o/NTP/NTP-Table.html)

# Windows 関連

## WINSサーバ

`wins server` で DHCPクライアント に渡す WINSサーバのIPアドレスを設定

```
wins server 192.168.0.123
```

`dhcp scope option` だと、DHCPサーバ単位で設定できる

```
dhcp scope 1 option wins_server=192.168.0.123
```

## フィルタリング

```
# Reject RPC (tcp, 135)
ip filter 1010 reject * * udp,tcp 135 *
ip filter 1011 reject * * udp,tcp * 135
# Reject NetBIOS (tcp, 139)
ip filter 1012 reject * * udp,tcp netbios_ns-netbios_ssn *
ip filter 1013 reject * * udp,tcp * netbios_ns-netbios_ssn
# Reject SMB (udp/tcp, 445)
ip filter 1014 reject * * udp,tcp 445 *
ip filter 1015 reject * * udp,tcp * 445
```

# 保守

## コンソール

言語 と 文字コード
```
console character ja.utf8
```

`utf8` は Rev.14.01 系以降 でないと使えない

## WebGUI

ダッシュボードのデータ蓄積
```
dashboard accumulate on
```

## ログレベル

ログレベル毎に 出力するかどうか設定できる
```
syslog debug on
syslog info on
syslog notice on
```

