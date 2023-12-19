package com.fairytale.server.service.payment;

import com.fairytale.server.model.payment.dto.PaymentDto;
import com.fairytale.server.model.payment.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void addPayment(PaymentDto paymentDto) {  paymentMapper.addPayment(paymentDto);}

    @Override
    public List<PaymentDto> paymentList(PaymentDto paymentDto) { return paymentMapper.paymentList(paymentDto); }

    @Override
    public List<PaymentDto> getDESCPaymentId() { return paymentMapper.getDESCPaymentId(); }

}
