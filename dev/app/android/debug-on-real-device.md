実機でデバッグ
================================

* [ハードウェア端末上でアプリを実行する | Android Studio](https://developer.android.com/studio/run/device.html)

* 接続確認
  ```
  % adb devices
  List of devices attached
  XXXXXXXXXXXXXXXX	device
  emulator-5554	device
  
  ```
  * XXXXXXXXXXXXXXXX のほうが実機
  
* build.gradle
  ```
  android {
      buildTypes {
          debug {
              debuggable true
          }
  ```

## on Ubuntu Linux
* udev ルールファイルを追加して、開発で使用する各種端末の USB 設定を含める必要があります。
  ```
  % cat /etc/udev/rules.d/51-android.rules 
  SUBSYSTEM=="usb", ATTR{idVendor}=="12d1", MODE="0666", GROUP="plugdev"

  % ll /etc/udev/rules.d/51-android.rules
  -rw-r--r-- 1 root root 72 Jan  4 11:45 /etc/udev/rules.d/51-android.rules
  ```
