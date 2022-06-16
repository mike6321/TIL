package com.example.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
/**
 * option : -Dspring.profiles.active="test"
 * */
public class TestConfiguration {

//    @Bean
//    public BookRepository bookRepository() {
//        return new TestBookRepository();
//    }

}
