package com.example.version.V_2_1.auto_setup_support;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final HelloService helloService;
    private final BookService bookService;

    public BookController(HelloService helloService, BookService bookService) {
        this.helloService = helloService;
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public String hello() {
        helloService.hello();
        helloService.hi();
        return "hello";
    }

    @GetMapping("/book")
    public Book book() {
        return bookService.finByIsbn("1234");
    }

}
