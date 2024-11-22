package com.example.innerclassbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 왜 "내부클래스" 작성 시 "적정 클래스" 로 만들어야 동작하는지 이유를 잘 모르겠다.
 *
 * */
@SpringBootApplication
public class InnerclassbeanApplication {

    // Static Nested Class
    // 위치만 같을 뿐 top level class 와 같다.
    // outer class 와 의미가 깊이 관여된 경우 이렇게 사용
    @Component
    static class StaticInnerClass {
        public StaticInnerClass() {
            System.out.println("StaticInnerClass constructor");

            // Local Class
            class LocalClass {
                public LocalClass() {
                    System.out.println("LocalClass constructor");
                }
            }


            // Anonymous Class
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("StaticInnerClass Runnable");
                }
            };

            System.out.println(runnable);
        }

    }

    // (Non-Static Nested Class) Inner Class
    @Component
    class InnerClass {
        public InnerClass() {
            System.out.println("InnerClass constructor");
        }
    }

    public static void main(String[] args) {
        // v1
        var applicationContext = SpringApplication.run(InnerclassbeanApplication.class, args);
        System.out.println(applicationContext.getBean(StaticInnerClass.class));
        System.out.println(applicationContext.getBean(InnerClass.class));

        StaticInnerClass staticInnerClass = new StaticInnerClass();

        var outerClass = new InnerclassbeanApplication();
        var innerClass = outerClass.new InnerClass();

        // v2
        var innerClass2 = applicationContext.getBean(OuterClass.InnerClass2.class);
        System.out.println(innerClass2);
    }

}
