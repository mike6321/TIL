package org.example;

import org.example.domain.Member;
import org.example.service.CreateMemberCommand;
import org.example.service.CreateMemberService;
import org.example.service.QueryMemberCommand;
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
        createMemberService.create(new CreateMemberCommand("junwoo.choi", "passwrodqwer!@#$"));

        System.out.println("############################# start #############################");
        createMemberService.getMember(new QueryMemberCommand("junwoo.choi"));
        createMemberService.getMember(new QueryMemberCommand("junwoo.choi"));
        createMemberService.getMember(new QueryMemberCommand("junwoo.choi"));
        createMemberService.getMember(new QueryMemberCommand("junwoo.choi"));
        System.out.println("##########################################################");

//        createMemberService.getAllMembers();
//        createMemberService.getAllMembers();
//        createMemberService.getAllMembers();

        CacheManager cacheManager = context.getBean("cacheManager", CacheManager.class);
        Cache cache = cacheManager.getCache("member");

        ConcurrentMapCache concurrentMapCache = ConcurrentMapCache.class.cast(cache);
        ConcurrentMap<SimpleKey, List<Member>> map = ConcurrentMap.class.cast(concurrentMapCache.getNativeCache());


        System.out.println("Map Size : " + map.size());
        map.entrySet()
                .forEach(simpleKeyListEntry -> System.out.println(simpleKeyListEntry.getKey() + " : " + simpleKeyListEntry.getValue()));

        System.out.println("############################# end #############################");
    }

}
