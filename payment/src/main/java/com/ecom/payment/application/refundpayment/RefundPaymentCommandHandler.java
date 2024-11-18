package com.ecom.payment.application.refundpayment;

import com.ecom.payment.domain.Payment;
import com.ecom.payment.domain.PaymetMethodEnum;
import com.ecom.payment.infrastructure.repositories.PaymentRepository;
import com.ecom.payment.infrastructure.services.MasterCardPaymentGateway;
import com.ecom.payment.infrastructure.services.PaypalPaymentGateway;
import com.ecom.shared.application.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class RefundPaymentCommandHandler implements CommandHandler<RefundPaymentCommand,Void> {

    private final MasterCardPaymentGateway masterCardPaymentGateway;
    private final PaymentRepository paymentRepository;
    private final PaypalPaymentGateway paypalPaymentGateway;

    public RefundPaymentCommandHandler(MasterCardPaymentGateway masterCardPaymentGateway, PaymentRepository paymentRepository, PaypalPaymentGateway paypalPaymentGateway) {
        this.masterCardPaymentGateway = masterCardPaymentGateway;
        this.paymentRepository = paymentRepository;
        this.paypalPaymentGateway = paypalPaymentGateway;
    }
    @Override
    public Void handle(RefundPaymentCommand command) {

        var payment = paymentRepository.findById(command.getPaymentId()).orElseThrow();
        doRefundPaymentByGateway(payment);
        payment.refund();
        paymentRepository.save(payment);
        return null;
    }

    private void doRefundPaymentByGateway(Payment payment) {
        if (payment.getPaymentMethod().equals(PaymetMethodEnum.MASTER_CARD)){
            masterCardPaymentGateway.refundPayment(payment.getTransactionId());
        } else if (payment.getPaymentMethod().equals(PaymetMethodEnum.PAYPAL)){
            paypalPaymentGateway.refundPayment(payment.getTransactionId());
        }
    }

}
