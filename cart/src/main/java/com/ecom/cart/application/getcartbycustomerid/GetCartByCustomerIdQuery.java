package com.ecom.cart.application.getcartbycustomerid;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class GetCartByCustomerIdCommand implements Command<GetCartByCustomerIdResponseDto> {

        @NotEmpty
        @NotBlank
        public UUID customerId;
}
