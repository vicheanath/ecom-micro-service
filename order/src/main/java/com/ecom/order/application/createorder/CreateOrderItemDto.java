package com.ecom.order.application.createorder;


import lombok.Data;

@Data
public class CreateOrderItemDto {
    private String productId;
    private int quantity;
}
