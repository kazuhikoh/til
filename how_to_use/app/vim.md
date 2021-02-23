# one liner

文字コード変換 (sjis,CRLF -> utf8,LF)
```
vim -c ":e ++enc=sjis" -c ":set fenc=utf8" -c ":set ff=unix" -c ":wq" sjis-awesome-memo.txt
```
