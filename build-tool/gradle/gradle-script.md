# Gradle Script

* gradleプロジェクトルート/build.gradle に記述する
* 言語は groovy

## Repositories

http://gradle.monochromeroad.com/docs/userguide/artifact_dependencies_tutorial.html
* 外部依存関係を探す場所を定義
``` gradle:build.gradle
repositories {
    jcenter()
    mavenCentral()
}
```

### ローカルのjarを指定

* How to add local .jar file dependency to build.gradle file?
http://stackoverflow.com/questions/20700053/how-to-add-local-jar-file-dependency-to-build-gradle-file

* libs/ にある jar を対象にするには
``` gradle:build.gradle
repository {
    flatDir {
      dirs 'libs'
    }
}
```

## SubProject

* プロジェクトルート直下にあるGradleプロジェクトを、子プロジェクトとして取り込む

* settings.gradle に SubProject を指定する
``` gradle:settings.gradle
include 'foo'               // SubProjectのディレクトリ名を指定
include 'foo', 'bar', 'baz' // comma区切りでも書ける
```
* build.gradle

  * 取り込む SubProject を指定する
  ``` gradle:build.gradle
  dependencies {
      compile project(':foo')
      compile project(':bar')
  }
  ```

  * SubProject に対する設定の記述
  ``` groovy:build.gradle
  project(':foo'){
      apply plugin: 'java'
      dependencies {
        compile(':bar')
      }
  }
  ```

## ファイル分割

    apply from: 'external.gradle'
