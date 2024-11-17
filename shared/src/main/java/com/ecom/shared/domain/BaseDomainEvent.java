package com.ecom.shared.domain;

import java.time.Instant;
import java.util.UUID;

public abstract class BaseDomainEvent implements DomainEvent {
    private Instant occurredOn;
    private String eventId;
    public BaseDomainEvent() {
        this.occurredOn = Instant.now();
        this.eventId = UUID.randomUUID().toString();
    }

    @Override
    public Instant getOccurredOn() {
        return occurredOn;
    }

    @Override
    public void setOccurredOn(Instant occurredOn) {
        this.occurredOn = occurredOn;
    }


}
