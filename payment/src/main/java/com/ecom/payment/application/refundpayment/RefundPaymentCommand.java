package com.ecom.payment.application.refundpayment;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class RefundPaymentCommand implements Command<Void> {
    @NotBlank
    @NotEmpty
    private UUID paymentId;
    @NotBlank
    @NotEmpty
    private String transactionId;
}
