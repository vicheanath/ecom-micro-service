package com.ecom.caltalog.infrastructure;

import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class JpaDomainEventInterceptor {

    private static ApplicationEventPublisher eventPublisher;

    public JpaDomainEventInterceptor(ApplicationEventPublisher eventPublisher) {
        JpaDomainEventInterceptor.eventPublisher = eventPublisher;
    }

    @PostPersist
    @PostUpdate
    @PreRemove
    public void publishEvents(Object entity) {
        if (entity instanceof AggregateRoot<?> aggregateRoot) {
            aggregateRoot.getDomainEvents().forEach(eventPublisher::publishEvent);
            aggregateRoot.clearDomainEvents();
        }
    }
}
