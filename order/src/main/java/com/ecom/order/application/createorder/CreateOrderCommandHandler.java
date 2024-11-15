package com.ecom.order.application.createorder;

import com.ecom.order.domain.Order;
import com.ecom.order.domain.OrderItem;
import com.ecom.order.infrastructure.repositories.OrderRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateOrderCommandHandler implements CommandHandler<CreateOrderCommand> {

    private final OrderRepository orderRepository;

    public CreateOrderCommandHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void handle(CreateOrderCommand command) {

        var order =  Order.create(
                UUID.randomUUID(),
                UUID.fromString(command.getCustomerId())
        );

//        command.getOrderItems().forEach(orderItem -> {
//
//            var item = OrderItem.create(
//                    UUID.randomUUID(),
//                    UUID.fromString(orderItem.productId()),
//                        orderItem.quantity()
//            );
//            order.addOrderItem(item);
//        });

    }
}
