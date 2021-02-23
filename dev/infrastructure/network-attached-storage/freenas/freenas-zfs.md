FreeNas で ZFS のファイルサーバ
================================

やりたいこと
--------------------------------
FreeNas + ZFS
* [Recommended Minimum Hardware](http://www.freenas.org/hardware-requirements/)
  * Multicore 64-bit processor
  * 16GB Boot Drive (USB Flash Drive suffices)
  * 16GB RAM (ECC Recommended)
* HDD x6
* RAID-Z3

ハードウェア構成
--------------------------------

|:fish:|:sushi:|
|:---|:---|
|ケース|[Fractal Design Node 304](https://www.ask-corp.jp/products/fractal-design/cube-pccase/node-304.html)|
|マザーボード|[ASRock H270M-ITX/ac](http://www.asrock.com/MB/Intel/H270M-ITXac/index.jp.asp)|
|CPU|[Intel Core i5-7500](https://ark.intel.com/ja/products/97123/Intel-Core-i5-7500-Processor-6M-Cache-up-to-3_80-GHz)|
|電源|[FSP700-80EGN](http://www.sparklepower.com/pdf/PC/FSP700-80EGN.pdf)|

### ケース選び

できるだけ、こじんまりしたものにしたい...
それで見つけたのが

<img src="https://www.ask-corp.jp/products/images/fractal-design/node-304_01.jpg" width="100">

[Fractal Design Node 304](https://www.ask-corp.jp/products/fractal-design/cube-pccase/node-304.html)
* 見た目がかっこいい
* 3.5インチ x6 を格納できる
* 対応マザーボード: Mini-ITX用
* 対応電源: ATX 12V（奥行き160mmまで）

### パーツ選び

次の条件を満たすものを探す.
* フォームファクタ: Mini-ITX
* CPUソケット: LGA2011(Intel Core i7-3930K が余ってるから使いたい)
* ECCメモリ対応
* SATA: x6

価格.com によると、そんな製品は存在しないらしい...
* mini-ITX で LGA2011 対応のものがない (LGA1150, LGA1511, LGA2011-3 のみ)
  * i7 を新しく買うのは厳しいので i5 にする
    * OC不要,グラフィック性能不要 => [Core i5-7500 (LGA1511)](https://ark.intel.com/ja/products/97123/Intel-Core-i5-7500-Processor-6M-Cache-up-to-3_80-GHz)

条件を変更.次の条件を満たすものを探す.
* フォームファクタ: Mini-ITX
* CPUソケット: LGA1511
* ECCメモリ対応
* SATA x6

しかし、mini-ITX で ECCメモリ対応 のものも全然ないらしい

|マザボ|CPU|CPUソケット|チップセット|メモリタイプ|最大搭載メモリ容量|ECCメモリ対応|SATA|価格|
|:----|:--|:--------|:--------|:---------|:----------:|:---------:|:--:|--:|
|[ASRock E3C236D2I](http://www.asrockrack.com/general/productdetail.asp?Model=E3C236D2I#Specifications)| Intel® Xeon® E3-1200 v5/v6 Series | LGA1151 | Intel® C236 | DIMM DDR4 (x2) | 32GB | OK | 6 | 41,837 |
|[ASRock X99E-ITX/ac](http://www.asrock.com/mb/Intel/X99E-ITXac/)|Intel® Core™ i7<br>Intel® Xeon® 22-Core Processors Family | LGA2011-v3 | Intel® X99 | DIMM DDR4 (x2) | 32GB | Xeon搭載時にはOK | 6 | 38,413 |
|[ASRock Fatal1ty AB350 Gaming-ITX/ac](http://www.asrock.com/MB/AMD/Fatal1ty%20AB350%20Gaming-ITXac/index.jp.asp)|||||||<font color="red">4</font>||
|[GIGABYTE GA-AB350N-Gaming WIFI (rev. 1.0)](http://www.gigabyte.jp/Motherboard/GA-AB350N-Gaming-WIFI-rev-10)| AMD Ryzen™ processor<br>AMD 7th Generation A-series/ Athlon™ processor | Socket AM4 | AMD B350 | DIMM DDR4 (x2) | 32GB | OK | <font color="red">4</font> | - |

ECCメモリ対応だと一気に高くなるので、妥協して条件変更
* フォームファクタ: Mini-ITX
* CPUソケット: LGA1511
* SATA x6

これを満たしてそこそこ安い↓に決定

|マザボ|CPU|CPUソケット|チップセット|メモリタイプ|最大搭載メモリ容量|ECCメモリ対応|SATA|価格|
|:----|:--|:--------|:--------|:---------|:----------:|:---------:|:--:|--:|
|[ASRock H270M-ITX/ac](http://www.asrock.com/MB/Intel/H270M-ITXac/index.jp.asp)| 第7世代および第6世代 Intel® Core™ i7/i5/i3/Pentium®/Celeron® | LGA1151 | Intel® H270 | DIMM DDR4 (x2) | 32GB | NG | 6 | 13,803 |

> 第 7 世代 Intel® CPU は最大 2400 までの DDR4 に対応

とのことなので、メモリは DIMM DDR4 2400 の
[crucial DW4U2400CM-8G](https://www.amazon.co.jp/gp/product/B01L6OC5LK/ref=ox_sc_act_title_5?ie=UTF8&psc=1&smid=AN1VRQENFRJN5)

電源は 余ってる [FSP700-80EGN](http://www.sparklepower.com/pdf/PC/FSP700-80EGN.pdf) で良さそう
  * [80 PLUS GOLD](https://ja.wikipedia.org/wiki/80_PLUS)
  * 140 x 150 x 85.8mm
  * 700W

ファンも 持ってるやつで多分いける
