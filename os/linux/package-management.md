Linux での パッケージ管理
================================

# Package Manager
| Distribution | Package Manager |
| :----------- | :-------------- |
| Debian系     | `apt`, (`apt-get`, `apt-cache`, `dpkg`) |
| RedHat系     | `dnf`, (`yum`,) `rpm` |
| FreeBSD系    | `pkg` |

# Debian系

`apt` で管理するのがよさげ
* 元々は `apt-get`, `apt-cache`, `dpkg` を使い分けて管理
* ↑を統合するために `apt` が登場

# RedHat系

`dnf` で管理するのがよさげ
* `yum` は `python 2.x` でかかれている
* `yum` から `dnf` へ以降 (Fedora22から) `python3`

# FreeBSD系

`pkg`しかない(?)

# References
* [Linux パッケージ管理コマンド比較](http://sig9.hatenablog.com/entry/2015/06/21/081407)
