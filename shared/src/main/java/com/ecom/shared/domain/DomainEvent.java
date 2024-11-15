package com.ecom.shared.domain;

import java.time.Instant;

public interface DomainEvent {
    Instant getOccurredOn();
}
