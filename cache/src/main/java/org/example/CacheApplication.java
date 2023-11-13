package org.example;

import org.example.repository.MemberRepository;
import org.example.repository.PasswordRepository;
import org.example.service.CreateMemberCommand;
import org.example.service.CreateMemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CacheApplication.class, args);
        CreateMemberService createMemberService = context.getBean("createMemberService", CreateMemberService.class);

        createMemberService.create(new CreateMemberCommand("junwoo.choi", "qwer!@#$"));

        context.getBean("memberRepository", MemberRepository.class).findAll()
                .forEach(System.out::println);
        context.getBean("passwordRepository", PasswordRepository.class).findAll()
                .forEach(System.out::println);
    }

}
