package com.ecom.shared.domain;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}