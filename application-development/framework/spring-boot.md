# SpringBootプロジェクトの作成

* [SPRING INITIALIZR](https://start.spring.io/)で作るのが速い
  * `gradle init`して `build.gradle`書いて ... の手間が省ける

# スタンドアローンなアプリをつくるには

スタンドアローンで起動してから入力待ち状態になるような、すぐ終了せずにずっと動き続けるアプリを作るには、
Componentに`CommandLineRunner`を実装して、`run()`が終了しないようにする。

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class StandaloneSample implements CommandLineRunner {
    
    private CountDownLatch latch = new CountDownLatch(1);
    
    @Override
    public void run(String... strings) throws Exception {
        latch.await();
    }
}
```

## 任意のタイミングで終了させる
他のComponentから任意のタイミングで終了させるには、終了通知イベントを用意して通知する。

```java
package com.example.standalonesample;

public class ExitEvent {}
```

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class StandaloneSample implements CommandLineRunner {
    
    private CountDownLatch latch = new CountDownLatch(1);
    
    @Override
    public void run(String... strings) throws Exception {
        latch.await();
    }
    
    @EventListener(ExitEvent.class)
    void onExit(){
        latch.countDown();
    }
    
}
```

# Tomcat にデプロイ可能な war の作成

* [85.1 Create a deployable war file](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html#howto-create-a-deployable-war-file)
* アプリの main となるクラスに `SpringBootServletInitializer ` を継承させる
