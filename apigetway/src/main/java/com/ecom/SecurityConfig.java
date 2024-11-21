//package com.ecom;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
////@Configuration
////@EnableWebFluxSecurity
////public class SecurityConfig {
////
////    @Bean
////    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
////
////        http
////            .csrf(
////                ServerHttpSecurity.CsrfSpec::disable
////            )
////            .authorizeExchange(exchanges ->
////                exchanges
////                    .pathMatchers("/auth/**").permitAll()
////                    .anyExchange().authenticated()
////            ).oauth2Login(withDefaults()).oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
////        return http.build();
////    }
////
////}
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authorizeExchange(exchanges ->
//                        exchanges
//                                .pathMatchers("/auth/**").permitAll()  // Public endpoints
//                                .anyExchange().authenticated()        // Secure all other endpoints
//                )
//                .oauth2Login(Customizer.withDefaults())         // OAuth2 login
//                .oauth2ResourceServer(oauth2 ->
//                        oauth2.jwt(jwt -> jwt.jwtDecoder(jwtDecoder()))  // Explicit JWT decoder
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public ReactiveJwtDecoder jwtDecoder() {
//        String jwkSetUri = "http://localhost:8080/auth/realms/<realm-name>/protocol/openid-connect/certs";
//        return NimbusReactiveJwtDecoder.withJwkSetUri(jwkSetUri).build();
//    }
//}
//


