package com.ecom.cart.application.getcartbycustomerid;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.infrastructure.repositories.CartRepository;
import com.ecom.shared.application.QueryHandler;
import org.springframework.stereotype.Service;

@Service
public class GetCartByCustomerIdQueryHandler implements QueryHandler<GetCartByCustomerIdQuery, GetCartByCustomerIdResponseDto> {

    private final CartRepository cartRepository;

    public GetCartByCustomerIdQueryHandler(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public GetCartByCustomerIdResponseDto handle(GetCartByCustomerIdQuery command) {
        Cart cart = cartRepository.findByCustomerId((command.customerId))
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        return new GetCartByCustomerIdResponseDto(
                cart.getId(),
                cart.getCustomerId(),
                cart.getItems().stream()
                        .map(cartItem -> new CartItemDo(
                                cartItem.getId(),
                                cartItem.getProduct().getId(),
                                cartItem.getQuantity()
                        ))
                        .toArray(CartItemDo[]::new)
        );
    }
}
