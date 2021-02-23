# Bru-lay の再生方法

Blu-ray を直接再生できるプレーヤーがないので、ファイルとして保存してから再生する必要がある

## BD --> .mkv
[MakeMKV](http://www.makemkv.com) を使うと、BDディスクの内容をmkvで保存できる

### Install MakeMKV
Linux版はフォーラムページにあるとのこと
> MakeMKV for Windows and Mac OS X is available for download below. MakeMKV for Linux is available on the [forum page](http://www.makemkv.com/forum2/viewtopic.php?f=3&t=224).

Make sure you have all required tools and libraries installed. You'll need GNU compiler and linker and header and library files for following libraries: glibc, openssl-0.9.8, zlib, expat, libavcodec, qt4 or qt5. You may use the following command to install all prerequisites on debian-based system like ubuntu
```
sudo apt-get install build-essential pkg-config libc6-dev libssl-dev libexpat1-dev libavcodec-dev libgl1-mesa-dev libqt4-dev
```

Download both binary and source packages:
* http://www.makemkv.com/download/makemkv-bin-1.10.5.tar.gz
* http://www.makemkv.com/download/makemkv-oss-1.10.5.tar.gz

Run ```make install``` !!!
```
% tar xvzf makemkv-oss-1.10.5.tar.gz
% cd makemkv-oss-1.10.5
% ./configure
% make
# make install
```

```
% tar xvzf makemkv-bin-1.10.5.tar.gz
% cd makemkv-bin-1.10.5
% make
# make install
```

### Run MakeMKV

あとはMakeMKVの言うことをきいてファイルを作成するだけ
