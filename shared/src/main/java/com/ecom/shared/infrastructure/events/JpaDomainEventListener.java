package com.ecom.shared.infrastructure.events;

import com.ecom.shared.domain.AggregateRoot;
import com.ecom.shared.domain.DomainEvent;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class JpaDomainEventListener {

    private static ApplicationEventPublisher eventPublisher;

    public JpaDomainEventListener(ApplicationEventPublisher eventPublisher) {
        JpaDomainEventListener.eventPublisher = eventPublisher;
    }

    @PostPersist
    @PostUpdate
    public void publishEvents(Object entity) {
        if (entity instanceof AggregateRoot) {
            AggregateRoot<?> aggregate = (AggregateRoot<?>) entity;
            for (DomainEvent event : aggregate.getDomainEvents()) {
                eventPublisher.publishEvent(event);
            }
            aggregate.clearDomainEvents();
        }
    }
}
