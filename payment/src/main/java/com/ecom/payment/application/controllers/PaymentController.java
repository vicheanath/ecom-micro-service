package com.ecom.payment.application.controllers;

import com.ecom.payment.application.getallpaymenttransaction.GetAllPaymentTransactionQuery;
import com.ecom.payment.application.getallpaymenttransaction.GetAllPaymentTransactionQueryResponse;
import com.ecom.payment.application.processpayment.ProcessPaymentCommand;
import com.ecom.payment.application.refundpayment.RefundPaymentCommand;
import com.ecom.shared.infrastructure.Mediator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private Mediator mediator;

    public PaymentController(Mediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping
    public List<GetAllPaymentTransactionQueryResponse> getPayment() {
        return mediator.ask(new GetAllPaymentTransactionQuery());
    }

    @PostMapping("/process")
    public void processPayment(@RequestBody ProcessPaymentCommand command) {
        mediator.send(command);
    }

    @PostMapping("/refund")
    public void refundPayment( @RequestBody RefundPaymentCommand command) {
        mediator.send(command);
    }



}
