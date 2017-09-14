# npm での package 管理方法

pacakge 毎に `^`, `~` を使い分けて、動作保証するバージョンは package-lock.json で指定するのが良さそう

## package.json での バージョン書式

|書式|管理方針|
|:--|:-------|
|`^1.2.3`| semver を信用する(minor version 変更 => 後方互換性あり) |
|`~1.2.3`| semver を信用しないけど patch なら後方互換性があるはず |
|`1.2.3` | 完全に固定 |
|`1.x.x` | wildcardの間隔で指定 |

参考
* [package.json のチルダ(~) とキャレット(^)](http://qiita.com/sotarok/items/4ebd4cfedab186355867)
* [npmのモジュールバージョン指定におけるチルダ(~)とキャレット(^)の違いについての直感的な理解](http://qiita.com/uehaj/items/443580da712d2ccee159)
