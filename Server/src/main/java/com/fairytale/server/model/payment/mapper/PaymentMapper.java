package com.fairytale.server.model.payment.mapper;

import com.fairytale.server.model.payment.dto.PaymentDto;
import  org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PaymentMapper {

    void addPayment (PaymentDto paymentDto);

    List<PaymentDto> paymentList (PaymentDto paymentDto);

    List<PaymentDto> getDESCPaymentId ();

}
