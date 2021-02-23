Git
================================

git clone <repository>
--------------------------------

サブモジュールも一緒に
```
git clone --recursive <repository>
```

git config
--------------------------------

### Set

```
git config <property> <value>
```

### Get

```
git config <property>
```

### List all

```
git config --list
git config -l
```

git push <remote_branch> <local_branch>
--------------------------------

```
git push origin develop
```

引数を省略したときは、`push.default` に従った挙動をする。
```
git push
```

タグをpushするとき
```
git push --tags
```

### Config

* push.default

  |Value     |Behavior                                                                                     |Note|
  |:---------|:--------------------------------------------------------------------------------------------|:---|
  |`nothing` |引数なしを禁止する                                                                             ||
  |`matching`|リモートに同名のブランチがあるローカルブランチを全てpush                                          |v2.0以前はデフォルト|
  |`upstream`|カレントブランチとリモートブランチの間に「追跡関係」がある場合のみ、カレントブランチをpush           |Git1.7.4.2以前の`tracking`|
  |`current` |カレントブランチと同名のリモートブランチが存在すればpush                                          ||
  |`simple`  |カレントブランチと同名のリモートブランチが存在する場合のみ、カレントブランチをpush                  |v2.0以降はデフォルト<br>v1.7.11で追加|

  * `matching` は危険
  * `simple` が良さげ
