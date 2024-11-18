package com.ecom.payment.domain;


import com.ecom.shared.domain.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;


@Getter
@Embeddable
public class Money extends ValueObject {

    private double amount;
    private String currency;

    public Money(double amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money() {
    }

    public static Money create(double amount, String currency) {
        return new Money(amount, currency);
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currencies must be the same.");
        }
        return new Money(amount + money.amount, currency);
    }

    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currencies must be the same.");
        }
        return new Money(amount - money.amount, currency);
    }
}