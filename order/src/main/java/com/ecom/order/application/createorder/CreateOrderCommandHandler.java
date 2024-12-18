package com.ecom.order.application.createorder;

import com.ecom.order.domain.Order;
import com.ecom.order.domain.OrderItem;
import com.ecom.order.infrastructure.repositories.OrderRepository;
import com.ecom.shared.application.CommandHandler;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateOrderCommandHandler implements CommandHandler<CreateOrderCommand, Void> {

    private OrderRepository orderRepository;

    public CreateOrderCommandHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Void handle(CreateOrderCommand command) {

        var order = Order.create(
                UUID.randomUUID(),
                UUID.fromString(command.getCustomerId())
        );

        command.getOrderItems().forEach(orderItem -> {
            var item = new OrderItem(
                    orderItem.getQuantity(),
                    orderItem.getPrice(),
                    UUID.fromString(orderItem.getProductId())
            );
            order.addOrderItem(item);
        });

        orderRepository.save(order);

        return null;
    }

}
