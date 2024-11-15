package com.ecom.domain;

import java.time.Instant;

public interface DomainEvent {
    Instant getOccurredOn();
}
