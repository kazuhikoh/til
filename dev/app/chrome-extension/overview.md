# Chrome Extension

* [Overview](https://developer.chrome.com/extensions/overview)

## 開発の流れ

UI と イベントに対する振舞い を定義していく

UI
|BrowserAction|アイコンクリックから実行される振舞い|
|PageAction|特定サイト表示時に実行される振舞い|

* BrowserAction か PageAction はどちらかしか定義できない.またはどちらも無し.

Event
|Event|Description|
|:---|:---|
|ContextMenu|コンテキストメニューから実行される振舞い|
|ContentScripts|DOM操作ができる|
|BackgroundPage|バックグラウンドで動作し続ける振舞い(非推奨!)|
|EventPage|あるイベント発生時に発火させる振舞い|

* BackgroundPage と EventPage はどちらかしか定義できない
  * BackgroundPage は 常に動作しつづけメモリを専有してしまうので、EventPage が推奨されている

参考
* [Chrome拡張の開発方法まとめ　その1：概念編](https://qiita.com/edit-mode/items/26d7a22233ecdf48fed8)

## プロジェクト構成

定められている構成は↓だけ.
```
project-root/
└ manifest.json
```

`manifest.json`に、アプリのメタ情報と、イベントに対する振舞いを記述する.
* イベントに対する振る舞いは、`js`ファイルのパスで指定する.`js`ファイルはパスが通ればどこに配置しても良い.

## マニフェスト

`manifest.json` に定義するフィールドについて

参考
* [Manifest File Format](https://developer.chrome.com/extensions/manifest)
* [Chrome 拡張機能のマニフェストファイルの書き方](https://qiita.com/mdstoy/items/9866544e37987337dc79)

### Required

|Key|Value|Description|
|:--|:----|:----|
|manifest_version|`2`                  |`manifest.json`自体のバージョン. 現在有効なのは`2`のみ|
|name            |`"AwesomeSuperGreat"`|アプリ名.45文字(Byte?)まで|
|version         |`"1.2.3"`              |アプリバージョン.最大4つまでの数字を`.`で区切った文字列を指定<br>semver準拠で充分だと思う|

### Recommended

|Key|Value|Description|
|:--|:----|:----|
|default_locale|`"en"`|[#i18n]|
|description|`"I'm a memory eater :P"`                      |アプリの説明.132(Byte?)文字まで.|
|icons|`{ "16": "icons/16.png", "48": "icons/48.png", ... }`|pngファイルが推奨されている. 16, 48, 128 があるといいらしい|

### Pick one (or none)
(0|1)つだけ指定する項目.

|BrowserAction|振舞いを`js`ファイルパスで指定|
|PageAction||

### Optional

## i18n

プロジェクトルートに `_locale`

`manifest.json` には 次の記述が必要となる.
```
{
  ...
  "default_locale": "ja_JP",
  ...
}
```

* i18n をしない場合は、`default_locale` を **定義してはいけない**

