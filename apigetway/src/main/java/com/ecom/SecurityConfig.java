package com.ecom;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(
                        exchanges -> exchanges
                                .pathMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                .pathMatchers("/auth/**").permitAll()
                                .anyExchange().permitAll()
                );

        return http.build();
    }
}

