package com.ecom.inventory;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ecom.inventory", "com.ecom.shared"})
@EnableDiscoveryClient
public class InventoryApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(InventoryApplication.class, args);
    }
}
