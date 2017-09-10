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
* SATA: x6

価格.com によると、そんな製品は存在しないらしい...
* mini-ITX で LGA2011 対応のものがない (LGA1150, LGA1511, LGA2011-3 のみ)
* i7 を新しく買うのは厳しいので i5 にする
  * OC不要,グラフィック性能不要 => Core i5-7500 (LGA1511)

条件を変更.次の条件を満たすものを探す.
* フォームファクタ: Miti-ITX
* CPUソケット: LGA1511
* SATA x6

マザボは
<img src="http://img1.kakaku.k-img.com/images/productimage/l/K0000932640.jpg" width="100">
[ASRock H270M-ITX/ac](http://www.asrock.com/MB/Intel/H270M-ITXac/index.jp.asp)
に決定
  * Mini-ITX
  * CPU: Core™ i7/i5/i3/Pentium®/Celeron
  * SATA: 6 ports
  * Chipset: Intel H270
  * SATA電源: ???
  * Memory: DIMM DDR4 x2 (~32GB)
    * RAM: DDR4 2400 (第 7 世代 Intel® CPU)
  * グラフィックに強いみたいでオーバースペックだけど、他に安いのが無いのでこれで

電源は 余ってる [FSP700-80EGN](http://www.sparklepower.com/pdf/PC/FSP700-80EGN.pdf) で良さそう
  * 140 x 150 x 85.8mm
  * 700W

ファンも 持ってるやつで多分いける

### 構成決定

以上より、構成は下記に決定

|:fish:|:sushi:|
|:---|:---|
|ケース|[Fractal Design Node 304](https://www.ask-corp.jp/products/fractal-design/cube-pccase/node-304.html)|
|マザーボード|[ASRock H270M-ITX/ac](http://www.asrock.com/MB/Intel/H270M-ITXac/index.jp.asp)|
|CPU|Intel Core i5-7500|
|電源|[FSP700-80EGN](http://www.sparklepower.com/pdf/PC/FSP700-80EGN.pdf)|
