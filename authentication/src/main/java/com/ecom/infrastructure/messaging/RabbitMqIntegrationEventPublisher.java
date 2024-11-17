package com.ecom.infrastructure.messaging;

import com.integration.IntegrationEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqIntegrationEventPublisher {

    private final AmqpTemplate amqpTemplate;

    public RabbitMqIntegrationEventPublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publish(String exchange, String routingKey, IntegrationEvent event) {
        amqpTemplate.convertAndSend(exchange, routingKey, event);
        System.out.println("Published integration event: " + event.getClass().getSimpleName());
    }
}