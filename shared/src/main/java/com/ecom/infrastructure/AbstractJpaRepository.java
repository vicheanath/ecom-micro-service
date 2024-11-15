package com.ecom.infrastructure;

import com.ecom.domain.AggregateRoot;
import com.ecom.domain.DomainEvent;
import com.ecom.domain.DomainEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractJpaRepository<T extends AggregateRoot<ID>, ID> implements JpaRepository<T, ID> {
    private final JpaRepository<T, ID> jpaRepository;
    private final DomainEventPublisher domainEventPublisher;

    protected AbstractJpaRepository(JpaRepository<T, ID> jpaRepository, DomainEventPublisher domainEventPublisher) {
        this.jpaRepository = jpaRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    public T save(T aggregate) {
        T savedEntity = jpaRepository.save(aggregate);
        publishDomainEvents(savedEntity);
        return savedEntity;
    }

    public void delete(T aggregate) {
        jpaRepository.delete(aggregate);
        publishDomainEvents(aggregate);
    }

    private void publishDomainEvents(T aggregate) {
        for (DomainEvent event : aggregate.getDomainEvents()) {
            domainEventPublisher.publish(event);
        }
        aggregate.clearDomainEvents();
    }
}