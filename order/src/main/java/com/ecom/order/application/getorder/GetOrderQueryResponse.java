package com.ecom.order.application.getorder;

public record GetOrderQueryResponse(String orderId, String orderStatus, double totalPrice) {

}
