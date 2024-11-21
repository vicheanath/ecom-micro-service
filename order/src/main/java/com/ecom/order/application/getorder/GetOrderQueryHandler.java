package com.ecom.order.application.getorder;

import com.ecom.order.infrastructure.repositories.OrderRepository;
import com.ecom.shared.application.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class GetOrderQueryHandler implements QueryHandler<GetOrderQuery, List<GetOrderQueryResponse>> {

    private final OrderRepository repository;

    public GetOrderQueryHandler(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GetOrderQueryResponse> handle(GetOrderQuery query) {
        return repository.findAll().stream()
                .map(order -> new GetOrderQueryResponse(
                        order.getId().toString(),
                        String.valueOf(order.getStatus()),
                        order.getTotalPrice()))
                .collect(toList());
    }
}
