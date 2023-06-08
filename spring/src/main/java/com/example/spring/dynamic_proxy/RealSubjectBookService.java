package com.example.spring.dynamic_proxy;

public class RealSubjectBookService implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println("rent :: " + book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("return :: " + book.getTitle());
    }

}
