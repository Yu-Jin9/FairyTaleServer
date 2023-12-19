package com.fairytale.server.controller.payment;

import com.fairytale.server.model.payment.dto.*;
import com.fairytale.server.service.payment.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/server/payment")
public class PaymentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/addPayment")
    @ResponseBody
    public void addPayment(@RequestBody PaymentDto paymentDto) {
        logger.info("@@@"+paymentDto.getAmount());
        paymentService.addPayment(paymentDto);
    }

    @PostMapping("/getDESCPaymentId")
    @ResponseBody
    public HashMap<String, Object> getDESCPaymentId() {
        HashMap<String, Object> mv = new HashMap<>();
        List<PaymentDto> list = paymentService.getDESCPaymentId();

        mv.put("paymentList", list);
        return mv;
    }

    @PostMapping("/paymentList")
    @ResponseBody
    public HashMap<String, Object> paymentList(@RequestBody PaymentDto paymentDto) {
        HashMap<String, Object> mv = new HashMap<>();
        List<PaymentDto> list = paymentService.paymentList(paymentDto);

        mv.put("paymentList", list);
        return mv;
    }
}
