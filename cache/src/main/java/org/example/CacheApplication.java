package org.example;

import org.example.service.CreateMemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CacheApplication.class, args);
        CreateMemberService createMemberService = context.getBean("createMemberService", CreateMemberService.class);

        System.out.println("############################# start #############################");

        createMemberService.getAllMembers();
        createMemberService.getAllMembers();
        createMemberService.getAllMembers();
        System.out.println("##########################################################");

        CacheManager cacheManager = context.getBean("cacheManager", CacheManager.class);
        System.out.println("CacheManager implements class : " + cacheManager.getClass().getCanonicalName());

        cacheManager.getCacheNames()
                        .forEach(name -> System.out.println("cache name : " + name));


        System.out.println("############################# end #############################");


    }

}
