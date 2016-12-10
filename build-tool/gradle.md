# Gradle

## links

https://docs.gradle.org/current/release-notes

http://gradle.monochromeroad.com/docs/

## gradle プロジェクト作成
    % gradle init
    % tree .
    .
    ├── gradle
    ├── build.gradle
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle

    2 directories, 6 files

### プロジェクトの種類を指定して作成

+ basic  
  何も指定しない時と同じ
+ pom  
+ java-library  
  src/main, src/test ができる
* scala-library  
* groovy-library  


    % gradle init --type java-library
    % tree .
    .
    ├── build.gradle
    ├── gradle
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle
    └── src
        ├── main
        │   └── java
        │       └── Library.java
        └── test
            └── java
                └── LibraryTest.java

    7 directories, 8 files

## Task実行

    % gradle <task>

### タスクを除外して実行
test タスクを除外して build を実行

    % gradle build -x test
