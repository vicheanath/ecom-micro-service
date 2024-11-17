package com.ecom.application.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests()

//                // Allow access to Swagger UI and OpenAPI documentation
//                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                // Allow access to the registration endpoint
//                .requestMatchers("/api/auth/**").permitAll()
//                // Authenticate all other requests
                .anyRequest().permitAll();

        return http.build();
    }

}
