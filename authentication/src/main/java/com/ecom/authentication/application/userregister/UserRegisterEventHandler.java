package com.ecom.authentication.application.userregister;

import com.ecom.authentication.domain.event.UserRegisterEvent;
import com.ecom.authentication.infrastructure.mapper.DomainToIntegrationEventMapper;
import com.ecom.authentication.infrastructure.messaging.RabbitMqIntegrationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserRegisterEventHandler {
    private final DomainToIntegrationEventMapper eventMapper;
    private final RabbitMqIntegrationEventPublisher eventPublisher;

    public UserRegisterEventHandler(DomainToIntegrationEventMapper eventMapper,
                                    RabbitMqIntegrationEventPublisher eventPublisher) {
        this.eventMapper = eventMapper;
        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener
    public void handle(UserRegisterEvent event) {
        var integrationEvent = eventMapper.userRegisterEventToUserRegisterIntegrationEvent(event);
        eventPublisher.publish("order", "order.created", integrationEvent);
        System.out.println("Published integration event: " + integrationEvent.getClass().getSimpleName());
    }
}
