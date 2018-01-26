# 改行コード変換

## CRLF -> LF

```
LF=$(printf '\\\012_'); LF=${LF%_}; sed -i 's/\\n/'"$LF"'/g' $file
```

## LF -> CRLF

```
sed -i -e 's/$/\r/g' $file
