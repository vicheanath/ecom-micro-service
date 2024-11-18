package com.ecom.cart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ecom.cart", "com.ecom.shared"})
@EnableDiscoveryClient
public class CartApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CartApplication.class, args);
    }
}
