package com.ecom.payment.application.getallpaymenttransaction;

import com.ecom.payment.infrastructure.repositories.PaymentRepository;
import com.ecom.shared.application.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPaymentTransactionQueryHandler implements QueryHandler<GetAllPaymentTransactionQuery, List<GetAllPaymentTransactionQueryResponse>> {

    private final PaymentRepository paymentRepository;

    public GetAllPaymentTransactionQueryHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<GetAllPaymentTransactionQueryResponse> handle(GetAllPaymentTransactionQuery query) {
        return paymentRepository.findAll().stream()
                .map(payment -> new GetAllPaymentTransactionQueryResponse(
                        payment.getId(),
                        payment.getOrderId(),
                        payment.getUserId(),
                        payment.getAmount().getAmount(),
                        payment.getCreatedAt(),
                        payment.getStatus().name(),
                        String.valueOf(payment.getPaymentMethod()),
                        payment.getTransactionId()
                ))
                .toList();
    }
}
