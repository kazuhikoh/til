# ベルがならないときの対処法

`echo -e '\a'` で 音がならない..

## PulseAudio のモジュールが読みこまれてない

* `/etc/pulse/default.pa` の次の行をアンコメント

  ``` /etc/pulse/default.pa
  ### Load something into the sample cache
  load-sample-lazy x11-bell /usr/share/sounds/freedesktop/stereo/bell.oga
  load-sample-lazy pulse-hotplug  /usr/share/sounds/freedesktop/stereo/device-added.oga
  load-sample-lazy pulse-coldplug /usr/share/sounds/freedesktop/stereo/device-added.oga
  load-sample-lazy pulse-access /usr/share/sounds/freedesktop/stereo/message.oga
  ```

  ``` /etc/pulse/default.pa
  ### Load X11 bell module
  load-module module-x11-bell sample=x11-bell
  ```

* pulseaudio を再起動する

  停止して
  ```
  pulseaudio -k
  ```

  起動する (-D: deamonとして)
  ```
  pulseaudio -D
  ```

  * 設定によっては自動で再起動する
    ``` ~/.config/pulse/client.conf

    ```


## Beep音がMuteになってる

`alsamixer` で PC Beep の Mute を解除する
```
alsamixer
```

## 参考
* [PulseAudio - ArchWiki](https://wiki.archlinuxjp.org/index.php/PulseAudio)
