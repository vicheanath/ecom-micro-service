package com.ecom.caltalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
// 8084
@SpringBootApplication
@ComponentScan(basePackages = {"com.ecom.caltalog", "com.ecom.shared"})
@EnableDiscoveryClient
public class CatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }
}
