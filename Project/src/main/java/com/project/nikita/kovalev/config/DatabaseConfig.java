package com.project.nikita.kovalev.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@Configuration
@EnableJpaRepositories("com.project.nikita.kovalev.repository")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.project.nikita.kovalev")
public class DatabaseConfig {

    @Resource
    private Environment env;

}
