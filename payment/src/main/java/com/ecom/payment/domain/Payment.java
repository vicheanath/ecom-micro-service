package com.ecom.payment.domain;

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
        this.status =PaymentStatus.PENDING;
    }

    public static Payment create(UUID id, UUID orderId, UUID userId, Money amount) {
        return new Payment(id, orderId, userId, amount);
    }

    public void complete(String transactionId, PaymetMethodEnum paymentMethod) {
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.status = PaymentStatus.COMPLETED;
    }

    public void refund() {
        this.status = PaymentStatus.REFUNDED;
    }

    public void cancel() {
        this.status = PaymentStatus.COMPLETED;
    }

    public void transactionFailed() {
        this.status = PaymentStatus.FAILED;
    }

    public boolean isCompleted() {
        return this.status == PaymentStatus.COMPLETED;
    }

    public void complete(String transactionId, com.ecom.payment.application.processpayment.PaymetMethodEnum paymetMethodEnum) {

    }
}
