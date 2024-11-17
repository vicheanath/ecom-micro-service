package com.ecom.order.application.createorder;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderCommand implements Command<Void> {
    private List<CreateOrderItemDto> orderItems;
    @NotNull
    @NotEmpty
    private String customerId;

}

