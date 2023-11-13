package org.example.config;

import org.example.CacheApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories(
        basePackageClasses = CacheApplication.class,
        jdbcOperationsRef = "userNamedParameterJdbcOperations",
        transactionManagerRef = "memberTransactionManager"
)
public class DatasourceConfig {

    @Bean
    @Primary
    public NamedParameterJdbcOperations userNamedParameterJdbcOperations() {
        return new NamedParameterJdbcTemplate(memberDatasource());
    }

    @Bean
    public PlatformTransactionManager memberTransactionManager() {
        return new DataSourceTransactionManager(memberDatasource());
    }

    @Bean
    public DataSource memberDatasource() {
        return memberDatasourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("datasource.member")
    public DataSourceProperties memberDatasourceProperties() {
        return new DataSourceProperties();
    }


}
