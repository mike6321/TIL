package com.example.spring.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("profileAppRunner")
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final ApplicationContext applicationContext;
    private final BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("**************Environment**************");
        Environment environment = applicationContext.getEnvironment();
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println("**************Environment**************");
    }

}
