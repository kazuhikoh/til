# 無線LANセキュリティ規格

| セキュリティ規格     | WPA2               | WPA                | WEP                     | Note                                                |
|----------------------|--------------------|--------------------|-------------------------|-----------------------------------------------------|
| 暗号化キー管理方式   | PSK<br> EAP        | PSK<br> EAP        | -                       | PSK: 事前共有キーを使う<br> EAP: RADIUSサーバで管理 |
| 認証方式             | -                  | -                  | OpenSystem<br> ShardKey |                                                     |
| 暗号化方式           | **AES**<br> (TKIP) | TKIP<br> (**AES**) | (WEP)                   | AES > TKIP                                          |
| 改竄検知領域         | MIC                | MIC                | ICV                     |                                                     |
| 改竄検知アルゴリズム | CCMP               | Michael            | CRC32                   |                                                     |
## References

* [無線LANの認証方式・暗号化方式について調べてみた - yoshida_eth0の日記](http://d.hatena.ne.jp/eth0jp/20100428/1272398928)
