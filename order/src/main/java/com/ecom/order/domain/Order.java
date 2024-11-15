package com.ecom.order.domain;

import com.ecom.order.domain.events.OrderCreatedEvent;
import com.ecom.order.infrastructure.JpaDomainEventInterceptor;
import com.ecom.shared.domain.AggregateRoot;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@EntityListeners(JpaDomainEventInterceptor.class)
@Data
public class Order extends AggregateRoot<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "total_price")
    private float totalPrice;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems = new ArrayList<>();


    private Order( UUID customerId) {
        this.customerId = customerId;
        this.status = "Pending";
    }

    public Order() {

    }

    public static Order create(UUID id, UUID customerId) {
        var order = new Order(customerId);
        order.addDomainEvent(new OrderCreatedEvent(id, customerId, order.totalPrice));
        return order;
    }
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }
}
