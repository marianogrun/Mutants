package com.mutants.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"com"})
@EnableJpaRepositories(basePackages="com.mutants.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="com.mutants.entities")
public class MutantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MutantsApplication.class, args);
    }

}