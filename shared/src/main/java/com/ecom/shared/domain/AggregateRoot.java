package com.ecom.shared.domain;

import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<ID> extends BaseEntity<ID> {
    @Transient
    private List<DomainEvent> domainEvents = new ArrayList<>();

    protected void addDomainEvent(DomainEvent event) {
        domainEvents.add(event);
    }

    public List<DomainEvent> getDomainEvents() {
        return domainEvents;
    }

    public void clearDomainEvents() {
        domainEvents.clear();
    }
}