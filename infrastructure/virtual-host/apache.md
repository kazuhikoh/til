Apache Virtual Hosts

# IP ベース

宛先IP で切り分け
- `192.168.0.1` --> `var/www/foo`
- `192.168.0.2` --> `var/www/bar`

```
<VirtualHost 192.168.0.1:80>
  DocumentRoot   "var/www/foo"
  CustomLog      logs/foo.access.log common
  ErrorLog       logs/foo.error.log
</VirtualHost>

<VirtualHost 192.168.0.2:80>
  DocumentRoot   "var/www/bar"
  CustomLog      logs/bar.access.log common
  ErrorLog       logs/bar.error.log
</VirtualHost>
```

# 名前ベース

`Host` ヘッダで切り分け
- `www.foo.com` --> `/var/www/foo`
- `www.bar.com` --> `/var/www/bar`

```
<VirtualHost *:80>
  ServerName www.foo.com
  DocumentRoot /var/www/foo
</VirtualHost>

<VirtualHost *:80>
  ServerName www.bar.com
  DocumentRoot /var/www/bar
</VirtualHost>
```
