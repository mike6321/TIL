package com.example.spring.dynamic_proxy;

public class ProxyBookService implements BookService {

    private final BookService bookService;

    public ProxyBookService(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public void rent(Book book) {
        System.out.println("********************대여**************************");
        bookService.rent(book);
        System.out.println("********************대여**************************");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("********************반납**************************");
        bookService.rent(book);
        System.out.println("********************반납**************************");
    }

}
