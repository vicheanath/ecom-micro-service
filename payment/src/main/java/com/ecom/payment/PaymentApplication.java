package com.ecom.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={ "com.ecom.payment", "com.ecom.shared" })
public class PaymentApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
