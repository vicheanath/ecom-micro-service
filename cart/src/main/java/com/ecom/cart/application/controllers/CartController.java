package com.ecom.cart.application.controllers;

import com.ecom.cart.application.addproducttocart.AddProductToCardCommand;
import com.ecom.cart.application.getcartbycustomerid.GetCartByCustomerIdQuery;
import com.ecom.cart.application.getcartbycustomerid.GetCartByCustomerIdResponseDto;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final Mediator mediator;

    public CartController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/get-cart-by-customer-id/{customerId}")
    public GetCartByCustomerIdResponseDto getCartByCustomerId(@PathVariable UUID customerId) {
        GetCartByCustomerIdQuery query = new GetCartByCustomerIdQuery(customerId);
        return mediator.ask(query);
    }

    @PostMapping("/add-product-to-cart")
    public void addProductToCart(AddProductToCardCommand command) {
        mediator.send(command);
    }



}

