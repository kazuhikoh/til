Shebang とは
================================
ファイル先頭 2Byte の `#!` のこと。

Shebang の書いてある行(1行目) は Shebang行 と呼ばれる。

Shebangが含まれるファイルの実行の仕組み
================================
UNIXでは 先頭2Byte が `#!` のとき、`#!` につづくコマンドが実行される。
このとき、コマンドの引数にはファイル名が指定される。

`#` から始まる行は多くの言語でコメントとして扱われるから、結果としてShebang行は無視されて、2行目以降のコードが実行される。

たとえば、`hello.sh` が↓だとすると
```
#!/bin/bash
echo hello.
```
`./hello.sh` と実行すると、 `/bin/bash hello.sh` が実行される。

Tips
================================

コマンドのパスが不定の場合の指定
--------------------------------
```
#!/usr/bin/env python
```
* `env` が `/usr/bin/env` にあることを前提とすれば、環境に依存しない指定ができる

参考
================================
http://x68000.q-e-d.net/~68user/unix/pickup?%A5%B7%A5%A7%A5%D0%A5%F3%A5%B0