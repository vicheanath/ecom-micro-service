package com.ecom.cart.application.getcartbycustomerid;

import com.ecom.shared.application.Query;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.UUID;

@Data
public class GetCartByCustomerIdQuery implements Query<GetCartByCustomerIdResponseDto> {

    @NotEmpty
    @NotBlank
    public UUID customerId;

    public GetCartByCustomerIdQuery(UUID customerId) {
        this.customerId = customerId;
    }
}
