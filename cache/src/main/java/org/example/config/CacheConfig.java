package org.example.config;

import org.example.cache.interceptor.MemberKeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public KeyGenerator memberKeyGenerator() {
        return new MemberKeyGenerator();
    }

}
