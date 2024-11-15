package com.ecom.order.application.createorder;

import com.ecom.shared.application.Command;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderCommand implements Command {
    private List<CreateOrderItemDto> orderItems;
    private String customerId;

}

