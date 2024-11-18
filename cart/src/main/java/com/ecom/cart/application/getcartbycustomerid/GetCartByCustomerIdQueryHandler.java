package com.ecom.cart.application.getcartbycustomerid;

import com.ecom.shared.application.CommandHandler;

public class GetCartByCustomerIdCommandHandler implements CommandHandler<GetCartByCustomerIdCommand, GetCartByCustomerIdResponseDto> {

    private final CartRepository cartRepository;

    public GetCartByCustomerIdCommandHandler(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public GetCartByCustomerIdResponseDto handle(GetCartByCustomerIdCommand command) {
        Cart cart = cartRepository.findByCustomerId(command.customerId)
                .orElseThrow(() -> new CartNotFoundException(command.customerId));

        return new GetCartByCustomerIdResponseDto(
                cart.getId(),
                cart.getCustomerId(),
                cart.getCartItems().stream()
                        .map(cartItem -> new CartItemDo(
                                cartItem.getId(),
                                cartItem.getProductId(),
                                cartItem.getQuantity()
                        ))
                        .toArray(CartItemDo[]::new)
        );
    }
}
