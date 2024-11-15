package com.ecom.domain;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}