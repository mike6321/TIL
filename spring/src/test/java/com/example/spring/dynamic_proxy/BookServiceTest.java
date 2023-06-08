package com.example.spring.dynamic_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    BookService bookService = new ProxyBookService(new RealSubjectBookService());

    @Test
    @DisplayName("di test")
    void test() {
        Book book = new Book("가상 면접 사례로 배우는 대규모 시스템 설계 기초");
        bookService.rent(book);
    }

}
