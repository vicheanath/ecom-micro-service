package com.ecom.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ecom.authentication", "com.ecom.shared"})
@EnableWebSecurity
@EnableDiscoveryClient
public class AuthenticationApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(AuthenticationApp.class, args);
    }

}
