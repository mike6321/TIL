package com.example.version.V_2_1.log_group;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @PostConstruct
    public void init() {
        Book book = new Book();
        book.setIsbn(RandomString.make(20));
        book.setTitle("spring boot update");
        bookRepository.save(book);
    }


}
