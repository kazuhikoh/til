Overview
========
* RaspberryPi の無線LAN機能は networking で管理する
  * networking は ifup,ifdown を使う
  * ifup,ifdown の設定は /etc/network/interfaces に書く
* 固定IPの設定は /etc/dhcpcd.conf に書く (Jessieから)

Setup
========

networking
--------
* Jessie では、サービスの管理は systemctl になってる
  
  ```
  systemctl [start|stop|restart] networking
  ```
  
WPA-PSK(AES)方式の場合
--------
* /etc/network/interfaces

  ```
  auto wlan0
  allow-hotplug wlan0
  iface wlan0 inet dhcp
    wpa-conf /etc/wpa_supplicant/wpa_supplicant.conf
  ```

* /etc/wpa_supplicant/wpa_supplicant.conf
  * wpa_passphrase で設定の雛形を出力
    ```
    wpa_passphrase SSID PASSPHRASE >> /etc/wpa_supplicant/wpa_supplicant.conf
    ```
  
  * こんなかんじにする
    ```
    ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
    update_config=1
  
    network={
      ssid="SSID"
      # pskのベタ書きコメントは消しておく.暗号化されたものだけ記述
      psk=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

      proto=WPA
      key_mgmt=WPA-PSK
      pairwise=CCMP
      group=CCMP
      priority=2
    }
    ```

固定IPを割り振る
--------
* /etc/dhcpcd.conf に、↓を追記

  ```
  interface wlan0
  static ip_address=192.168.0.111/24
  static routers=192.168.0.1
  static domain_name_servers=192.168.0.1
  ```

パワーマネジメント機能をOFFにする
--------
* 省エネモードにならないようにする
* 現在の設定は `iwconfig` で確認できる

* /etc/network/interfaces で設定
  ```
  wireless-power off
  ```

* /etc/modprobe.d/8192cu.conf で設定
  ``` 
  options 8192cu rtw_power_mgnt=0 rtw_enusbss=1 rtw_ips_mode=1
  ```

  * iwconfig で OFF と表示されても、OFFになってない場合もあるらしい。こっちの方法だと確実?
  * [Raspberry Piで無線LANの反応が悪い時の対処法](http://denshikousaku.net/fix-sluggish-response-of-raspberry-pi-wifi-adaptor)
