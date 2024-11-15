package com.ecom.order.application.controller;


import com.ecom.order.application.createorder.CreateOrderCommand;
import com.ecom.order.application.getorder.GetOrderQuery;
import com.ecom.order.application.getorder.GetOrderQueryResponse;
import com.ecom.shared.application.CommandHandler;
import com.ecom.shared.application.QueryHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final CommandHandler<CreateOrderCommand> createOrderCommandHandler;

    private final QueryHandler<GetOrderQuery, List<GetOrderQueryResponse>> getOrderQueryHandler;

    public OrderController(CommandHandler<CreateOrderCommand> createOrderCommandHandler, QueryHandler<GetOrderQuery, List<GetOrderQueryResponse>> getOrderQueryHandler) {
        this.createOrderCommandHandler = createOrderCommandHandler;
        this.getOrderQueryHandler = getOrderQueryHandler;
    }

    @GetMapping()
    public ResponseEntity<List<GetOrderQueryResponse>> getOrder() {
        return ResponseEntity.ok(getOrderQueryHandler.handle(new GetOrderQuery()));
    }

    @PostMapping()
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        createOrderCommandHandler.handle(createOrderCommand);
        return ResponseEntity.ok().build();
    }
}
