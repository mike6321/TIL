package com.example.spring.dynamic_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BookServiceCglibTest {


    @Test
    @DisplayName("di test")
    void test() {
        BookService bookService = (BookService) Enhancer.create(RealSubjectBookService.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                final BookService bookService = new RealSubjectBookService();
                if (method.getName().equals("rent")) {
                    System.out.println("********************대여**************************");
                    Object invoke1 = method.invoke(bookService, objects);
                    System.out.println("********************대여**************************");
                    return invoke1;
                }
                System.out.println("********************반납**************************");
                Object invoke2 = method.invoke(bookService, objects);
                System.out.println("********************반납**************************");
                return invoke2;
            }
        });

        Book book = new Book("가상 면접 사례로 배우는 대규모 시스템 설계 기초");
        bookService.rent(book);
        bookService.returnBook(book);
    }

}
