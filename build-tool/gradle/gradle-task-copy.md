# CopyTask

* Gradleで ファイルコピーをするには、CopyTask を使う
    * type: Copy
    * from は複数指定できる
    * into は一つしか指定できない
``` groovy
// src/main/resources/*.properties --> $buildDir
task copy(type: Copy) {
    from 'src/main/resources'
    into '$buildDir/resources'
    include '*.properties'
}
```

# Project.copy

* 1つのタスクで from:into=1:1 でないコピーをするなら、こっちで書いたほうが綺麗
* 複数from 複数into も1つのタスクで実行できる
``` groovy
task copy {
  // src/main/resources/*.properties --> $buildDir/prop/
  copy {
    from 'src/main/resources'
    into '$buildDir/prop'
    include '*.properties'
  }
  // src/main/resources/*.xml        --> $buildDir/xml/
  copy {
    from 'src/main/resources'
    into '$buildDir/xml'
    include '*.xml'
  }
}
```
