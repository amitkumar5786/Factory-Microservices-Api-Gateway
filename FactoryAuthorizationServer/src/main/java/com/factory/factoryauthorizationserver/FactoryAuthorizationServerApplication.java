package com.factory.factoryauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@Configuration
public class FactoryAuthorizationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FactoryAuthorizationServerApplication.class, args);
    }
}
