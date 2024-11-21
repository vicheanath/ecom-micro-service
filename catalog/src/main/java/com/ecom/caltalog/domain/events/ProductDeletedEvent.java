package com.ecom.caltalog.domain.events;

import com.ecom.shared.domain.BaseDomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDeletedEvent extends BaseDomainEvent {
    public String productId;

}
