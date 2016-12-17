# sshd

## Install
```
# apt-get install openssh-server
```

## Start,Stop,...
```
# systemctl [start|stop|restart|status] sshd
```

## Settings
* /etc/ssh/sshd_config

Protocol
* 1 は脆弱性がいっぱいらしいので 2 にする
``` /etc/ssh/sshd_config
Protcol 2
```

公開鍵認証
``` /etc/ssh/sshd_config
PubkeyAuthentication yes
AuthorizedKeysFile  %h/.ssh/authorized_keys

PasswordAuthentication no
```

ルータからポートフォワードしてWANに公開する場合
```
AllowTcpForwarding yes
GatewayPorts yes
```
