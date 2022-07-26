package com.example.demofamilymanprep;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FamilyManAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public FamilyMan familyMan() {
        FamilyMan familyMan = new FamilyMan();
        familyMan.setName("origin-junwoo");
        return familyMan;
    }

}
