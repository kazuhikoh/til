Reverse Proxy (Apache)

```
LoadModule proxy_module modules/mod_proxy.so
LoadModule proxy_http_module modules/mod_proxy_http.so

ProxyRequests Off
ProxyPass        /foo http://foo.example.com/bar
ProxyPassReverse /foo http://foo.example.com/bar
```

必要なモジュール
- proxy_module
- proxy_http_module

ProxyRequests: Off
- フォワードプロキシ を無効にする
