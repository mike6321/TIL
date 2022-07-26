package com.example.version.V_2_1.auto_setup_support;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        Book book = new Book();
        book.setIsbn("1234");
        book.setTitle("spring boot update");
        bookRepository.save(book);
    }

    public Book finByIsbn(String isbn) {
        return bookRepository.finByIsbn("1234");
    }

}
