node.js のバージョン管理
* [creationix/nvm](https://github.com/creationix/nvm/blob/master/README.md#installation) (Apple macOS / Linux)
* [coreybutler/nvm-windows](https://github.com/coreybutler/nvm-windows) (Microsoft Windows)

# coreybutler/nvm-windows (Microsoft Windows)

[リリースノート](https://github.com/coreybutler/nvm/releases) から インストーラ をDLして実行
=> `nvm` が使える状態になる。

インストール可能なバージョンを確認
```
> nvm list available
|   CURRENT    |     LTS      |  OLD STABLE  | OLD UNSTABLE |
|--------------|--------------|--------------|--------------|
|    9.8.0     |    8.10.0    |   0.12.18    |   0.11.16    |
|    9.7.1     |    8.9.4     |   0.12.17    |   0.11.15    |
|    9.7.0     |    8.9.3     |   0.12.16    |   0.11.14    |
|    9.6.1     |    8.9.2     |   0.12.15    |   0.11.13    |
|    9.6.0     |    8.9.1     |   0.12.14    |   0.11.12    |
```

使いたいバージョンをインストールする
```
>nvm install 9.8.0
Downloading node.js version 9.8.0 (64-bit)...
Complete
Creating C:\Users\hiramatsu\AppData\Roaming\nvm\temp

Downloading npm version 5.6.0... Complete
Installing npm v5.6.0...

Installation complete. If you want to use this version, type

nvm use 9.8.0
```

使いたいバージョンに切替え
```
> nvm use 9.8.0
Now using node v9.8.0 (64-bit)
```

### Error: `npm` cannot find module 'semver'

Prerequisite
* nvm 1.1.5

```
> npm v
module.js:545
    throw err;
    ^

Error: Cannot find module 'semver'
    at Function.Module._resolveFilename (module.js:543:15)
    at Function.Module._load (module.js:470:25)
    at Module.require (module.js:593:17)
    at require (internal/module.js:11:18)
    at Object.<anonymous> (C:\Users\hiramatsu\AppData\Roaming\nvm\v9.8.0\node_modules\npm\lib\utils\unsupported.js:2:14)
    at Module._compile (module.js:649:30)
    at Object.Module._extensions..js (module.js:660:10)
    at Module.load (module.js:561:32)
    at tryModuleLoad (module.js:501:12)
    at Function.Module._load (module.js:493:3)
module.js:545
    throw err;
    ^

Error: Cannot find module 'semver'
    at Function.Module._resolveFilename (module.js:543:15)
    at Function.Module._load (module.js:470:25)
    at Module.require (module.js:593:17)
    at require (internal/module.js:11:18)
    at Object.<anonymous> (C:\Users\hiramatsu\AppData\Roaming\nvm\v9.8.0\node_modules\npm\lib\utils\unsupported.js:2:14)
    at Module._compile (module.js:649:30)
    at Object.Module._extensions..js (module.js:660:10)
    at Module.load (module.js:561:32)
    at tryModuleLoad (module.js:501:12)
    at Function.Module._load (module.js:493:3)

```

