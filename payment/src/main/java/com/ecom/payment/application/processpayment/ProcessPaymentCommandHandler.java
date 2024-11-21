package com.ecom.payment.application.processpayment;

import com.ecom.payment.domain.Money;
import com.ecom.payment.domain.Payment;
import com.ecom.payment.infrastructure.repositories.PaymentRepository;
import com.ecom.payment.infrastructure.services.MasterCardPaymentGateway;
import com.ecom.payment.infrastructure.services.PaypalPaymentGateway;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProcessPaymentCommandHandler implements CommandHandler<ProcessPaymentCommand, Void> {

    private final MasterCardPaymentGateway masterCardPaymentGateway;
    private final PaymentRepository paymentRepository;
    private final PaypalPaymentGateway paypalPaymentGateway;


    public ProcessPaymentCommandHandler(MasterCardPaymentGateway masterCardPaymentGateway, PaymentRepository paymentRepository, PaypalPaymentGateway paypalPaymentGateway) {
        this.masterCardPaymentGateway = masterCardPaymentGateway;
        this.paymentRepository = paymentRepository;
        this.paypalPaymentGateway = paypalPaymentGateway;
    }

    @Override
    public Void handle(ProcessPaymentCommand command) {

        var amount = Money.create(command.getAmount(), "USD");
        var payment = Payment.create(UUID.randomUUID(), command.getOrderId(), command.getUserId(), amount);
        processPaymentSuccessOrFailed(command, payment);
        paymentRepository.save(payment);
        return null;
    }

    private void processPaymentSuccessOrFailed(ProcessPaymentCommand command, Payment payment) {
        try {
            processPayment(command, payment);
        } catch (Exception e) {
            payment.transactionFailed();
        }
    }

    private void processPayment(ProcessPaymentCommand command, Payment payment) {
        String transactionId = null;
        if (command.getPaymentMethod().equals(PaymetMethodEnum.MASTER_CARD)) {
            transactionId = masterCardPaymentGateway.processPayment(payment.getAmount(), payment.getId().toString());
            payment.complete(transactionId, com.ecom.payment.domain.PaymetMethodEnum.MASTER_CARD);
        } else if (command.getPaymentMethod().equals(PaymetMethodEnum.PAYPAL)) {
            transactionId = paypalPaymentGateway.processPayment(payment.getAmount(), payment.getId().toString());
            payment.complete(transactionId, com.ecom.payment.domain.PaymetMethodEnum.PAYPAL);
        }
    }
}
