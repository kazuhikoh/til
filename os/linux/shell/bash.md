# Bash

* [Bash - GNU Project - Free Software Foundation](https://www.gnu.org/software/bash/)

## Setting files

| filepath       | 読み込まれるとき          |
|:---------------|:-----------------------|
| /etc/profile   | ログイン時               |
| ~/.bash_profile| /etc/profile の次       |
| ~/.bash_login  | .bash_profile がないとき |
| ~/.profile     | .bash_login がないとき   |
| ~/.bashrc      | インタラクティブシェル起動時 | 
| ~/.bash_logout | ログアウト時              |

* /etc/profile は BourceShell系のものから読み込まれるみたい

  ``` /etc/profile
  # /etc/profile: system-wide .profile file for the Bourne shell (sh(1))
  # and Bourne compatible shells (bash(1), ksh(1), ash(1), ...).
  ```
