package com.ecom.payment.application.processpayment;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProcessPaymentCommand implements Command<Void> {

    @NotBlank
    private UUID userId;

    @NotBlank
    private UUID orderId;
    @NotBlank
    @Min(0)
    private double amount;
    @NotBlank
    private PaymetMethodEnum paymentMethod;
}


