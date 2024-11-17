package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ecom.domain.repositories")
@EnableWebSecurity
public class App 
{
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
    }

}
