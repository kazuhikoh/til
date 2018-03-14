# [pyenv](https://github.com/pyenv/pyenv)

## Install

`pyenv/pyenv` を好きな場所に clone
```
git clone https://github.com/pyenv/pyenv.git ~/.pyenv
```

シェル起動時に読み込まれるファイル(`.zshrc|.bashrc`) に 環境変数設定とかを追記
```
# `PYENV_ROOT`に clone したディレクトリを指定して、PATHを通す
export PYENV_ROOT="$HOME/.pyenv"
export PATH="$PYENV_ROOT/bin:$PATH"

# Enable shims and autocompletion
eval "$(pyenv init -)"
```

### Cygwin の場合

`python-build` が使えないので `pyenv install` が使えない

しょうがないので、zip をDLして `$PYENV_ROOT/versions/X.X.X` に配置して
```
mv python-3.6.4-embed-amd64 $PYENV_ROOT/versions/3.6.4
```

`$PYENV_ROOT/versions/X.X.X/bin/python` に `python.exe` へのシンボリックリンクを張る
```
cd $PYENV_ROOT/versions/3.6.4
mkdir bin; cd bin
ln -s ../python.exe python
```

参考
* [windows + cygwin で pyenv の環境構築 - 今からお前んちこいよ](http://www.hakopako.net/entry/2017/09/15/191140)

## Usage

リリースされているバージョンを確認
```
pyenv install --list
```

使いたいバージョンをインストール
```
pyenv install 3.6.4
```

使いたいバージョンに切り替える (global)
```
pyenv global 3.6.4
```

使いたいバージョンに切り替える (local)
```
pyenv local 3.6.4
```
* `./.python-version` が作成される
