package com.fairytale.server.service.payment;

import com.fairytale.server.model.payment.dto.PaymentDto;
import com.fairytale.server.model.payment.mapper.PaymentMapper;

import  java.util.List;

public interface PaymentService {

    void addPayment (PaymentDto paymentDto);

    List<PaymentDto> paymentList (PaymentDto paymentDto);

    List<PaymentDto> getDESCPaymentId ();

}
