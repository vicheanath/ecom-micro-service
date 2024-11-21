package com.ecom.cart.application.addproducttocart;

import com.ecom.shared.application.Command;
import lombok.Data;

import java.util.UUID;

@Data
public class AddProductToCardCommand implements Command<Void> {

    public UUID userId;
    public UUID cartId;
    public UUID productId;
    public Integer quantity;
}
