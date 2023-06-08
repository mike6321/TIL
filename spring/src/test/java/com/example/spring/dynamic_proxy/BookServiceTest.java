package com.example.spring.dynamic_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BookServiceTest {

    BookService bookService = (BookService) Proxy.newProxyInstance(
            BookService.class.getClassLoader(),
            new Class[]{BookService.class},
            new InvocationHandler() {
                final BookService bookService = new RealSubjectBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("rent")) {
                        System.out.println("********************대여**************************");
                        Object invoke1 = method.invoke(bookService, args);
                        System.out.println("********************대여**************************");
                        return invoke1;
                    }

                    System.out.println("********************반납**************************");
                    Object invoke2 = method.invoke(bookService, args);
                    System.out.println("********************반납**************************");
                    return invoke2;
                }
    });

    @Test
    @DisplayName("di test")
    void test() {
        Book book = new Book("가상 면접 사례로 배우는 대규모 시스템 설계 기초");
        bookService.rent(book);
        bookService.returnBook(book);
    }

}
