package com.ecom.domain;

import java.util.UUID;

public class OrderItem extends ValueObject{
    private UUID id;
    private UUID productId;
    private int quantity;
    private double unitPrice;
}
