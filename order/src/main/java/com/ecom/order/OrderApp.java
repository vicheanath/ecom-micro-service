package com.ecom.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderApp.class, args);
        System.out.println("Order service started...");
    }
}
