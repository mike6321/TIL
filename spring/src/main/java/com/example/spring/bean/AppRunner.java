package com.example.spring.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("beanAppRunner")
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("*********bean*********");
        // 모든 빈 조회
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        // 특정 빈 조회
        BeanTestImplRepository beanTestRepositoryImplByName = (BeanTestImplRepository) applicationContext.getBean("beanTestRepository");
        System.out.println("beanTestRepositoryImplByName = " + beanTestRepositoryImplByName);
        BeanTestRepository beanTestRepositoryByNameAndClass = applicationContext.getBean("beanTestRepository", BeanTestRepository.class);
        System.out.println("beanTestRepositoryByNameAndClass = " + beanTestRepositoryByNameAndClass);
        BeanTestRepository beanTestRepositoryByClass = applicationContext.getBean(BeanTestRepository.class);
        System.out.println("beanTestRepositoryByClass = " + beanTestRepositoryByClass);
        System.out.println("*********bean*********");
    }

}
