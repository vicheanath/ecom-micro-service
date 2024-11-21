package com.ecom.cart.application.addproducttocart;

import com.ecom.cart.domain.Cart;
import com.ecom.cart.domain.CartItem;
import com.ecom.cart.infrastructure.repositories.CartRepository;
import com.ecom.cart.infrastructure.repositories.ProductRepository;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AddProductToCartCommandHandler implements CommandHandler<AddProductToCardCommand, Void> {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public AddProductToCartCommandHandler(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Void handle(AddProductToCardCommand command) {
        var cart = ifCartNotExistCreate(command.getCartId(), command.getUserId());
        var product = productRepository.findById(command.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        var cartItem = CartItem.create(command.getQuantity(), product.getPrice(), product);
        cart.addCartItem(cartItem);
        cartRepository.save(cart);
        return null;
    }

    private Cart ifCartNotExistCreate(UUID cartId, UUID customerId) {
        return cartRepository.findById(cartId).orElseGet(() -> {
            var cart = Cart.create(cartId, customerId);
            cartRepository.save(cart);
            return cart;
        });
    }
}
