package com.ecom.infrastructure;

import com.ecom.shared.domain.AggregateRoot;
import com.ecom.shared.domain.DomainEvent;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class JpaDomainEventInterceptor {

    private static ApplicationEventPublisher eventPublisher;

    public JpaDomainEventInterceptor(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostPersist
    @PostUpdate
    @PreRemove
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
