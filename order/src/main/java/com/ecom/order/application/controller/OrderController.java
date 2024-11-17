package com.ecom.order.application.controller;


import com.ecom.order.application.createorder.CreateOrderCommand;
import com.ecom.order.application.getorder.GetOrderQuery;
import com.ecom.order.application.getorder.GetOrderQueryResponse;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final Mediator mediator;

    public OrderController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping()
    public List<GetOrderQueryResponse> getOrder() {
        return mediator.ask(new GetOrderQuery());
    }

    @PostMapping()
    public Void createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        mediator.send(createOrderCommand);
        return null;
    }
}
