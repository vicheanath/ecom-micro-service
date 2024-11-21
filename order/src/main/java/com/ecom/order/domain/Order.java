package com.ecom.order.domain;

import com.ecom.order.domain.events.OrderCancelledEvent;
import com.ecom.order.domain.events.OrderCompletedEvent;
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

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems = new ArrayList<>();


    private Order( UUID customerId) {
        this.customerId = customerId;
        this.status = OrderStatus.PENDING;
        calculateTotalPrice();
    }

    public Order() {

    }

    public static Order create(UUID id, UUID userId) {
        var order = new Order(userId);
        order.addDomainEvent(new OrderCreatedEvent(id, userId, order.totalPrice, order.orderItems, order.status));
        return order;
    }
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void calculateTotalPrice() {
        totalPrice = orderItems.stream().map(OrderItem::getTotalPrice).reduce(0f, Float::sum);
    }

    public void orderCancelled(String reason) {
        this.status = OrderStatus.CANCELLED;
        addDomainEvent(new OrderCancelledEvent(this.id, reason));
    }

    public void orderCompleted(UUID paymentId) {
        this.status = OrderStatus.COMPLETED;
        addDomainEvent(new OrderCompletedEvent(this.id, paymentId, status));
    }
}
