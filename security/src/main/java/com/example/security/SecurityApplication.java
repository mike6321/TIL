package com.example.security;

import com.example.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = Utils.BASE_PACKAGE_URL)
@EntityScan(basePackages = Utils.BASE_PACKAGE_URL)
@EnableJpaRepositories(basePackages = Utils.BASE_PACKAGE_URL)
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
