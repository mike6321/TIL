package com.example.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public BeanTestRepository beanTestRepository() {
        return new BeanTestImplRepository();
    }

}
