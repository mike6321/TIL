package org.example;

import org.example.domain.Member;
import org.example.service.CreateMemberCommand;
import org.example.service.CreateMemberService;
import org.example.service.QueryMemberCommand;
import org.example.service.QueryMemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

@SpringBootApplication
public class CacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CacheApplication.class, args);
        CreateMemberService createMemberService = context.getBean("createMemberService", CreateMemberService.class);
        QueryMemberService queryMemberService = context.getBean("queryMemberService", QueryMemberService.class);
        createMemberService.create(new CreateMemberCommand("junwoo.choi", "passwrodqwer!@#$"));

        System.out.println("############################# start #############################");
        queryMemberService.getMember(new QueryMemberCommand("junwoo.choi"));
        queryMemberService.getMember(new QueryMemberCommand("junwoo.choi"));
        System.out.println("##########################################################");

        CacheManager cacheManager = context.getBean("cacheManager", CacheManager.class);
        System.out.println(cacheManager.getClass().getCanonicalName());
        Cache cache = cacheManager.getCache("members");
        System.out.println(cache.get("member:user-code:junwoo.choi").get().toString());

        cache = cacheManager.getCache("members:user-codes");
        System.out.println(cache.get("member:user-code:junwoo.choi").get().toString());
        System.out.println(cache.get("member:user-code:junwoo.choi").get().toString());


        com.github.benmanes.caffeine.cache.Cache caffeineCache = (com.github.benmanes.caffeine.cache.Cache) cache.getNativeCache();
        System.out.println(caffeineCache.estimatedSize());
        System.out.println(caffeineCache.stats().toString());
        System.out.println("############################# end #############################");
    }

}
