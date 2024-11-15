package com.integration;

import java.io.Serializable;
import java.time.Instant;

public abstract class IntegrationEvent implements Serializable {
    private final Instant occurredOn;
    private static final long serialVersionUID = 1L;

    public IntegrationEvent() {
        this.occurredOn = Instant.now();
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }
}