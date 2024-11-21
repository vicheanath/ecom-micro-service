package com.ecom.payment.domain;

import com.ecom.payment.domain.events.PaymentCompletedEvent;
import com.ecom.payment.domain.events.PaymentFailedEvent;
import com.ecom.payment.domain.events.PaymentInitiatedEvent;
import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class Payment extends AggregateRoot<UUID> {

    @Id
    private UUID id;

    private UUID orderId;

    private UUID userId;

    @Embedded
    private Money amount;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    private PaymetMethodEnum paymentMethod;

    private String transactionId;

    public Payment() {
    }


    public Payment(UUID id, UUID orderId, UUID userId, Money amount) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
    }

    public static Payment create(UUID id, UUID orderId, UUID userId, Money amount) {
        var payment = new Payment(id, orderId, userId, amount);
        payment.addDomainEvent(new PaymentInitiatedEvent(id, orderId, userId, amount.getAmount(), String.valueOf(payment.getStatus())));
        return payment;
    }

    public void complete(String transactionId, PaymetMethodEnum paymentMethod) {
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.status = PaymentStatus.COMPLETED;
        addDomainEvent(new PaymentCompletedEvent(this.id, this.orderId, String.valueOf(this.status)));
    }

    public void refund() {
        this.status = PaymentStatus.REFUNDED;
    }

    public void transactionFailed() {
        this.status = PaymentStatus.FAILED;
        addDomainEvent(new PaymentFailedEvent(this.id, this.orderId, String.valueOf(this.status)));
    }
}
