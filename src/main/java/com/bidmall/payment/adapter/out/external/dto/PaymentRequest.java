package com.bidmall.payment.adapter.out.external.dto;

import java.math.BigDecimal;

/**
 * 외부 결제 게이트웨이 요청 객체
 */
public record PaymentRequest(
        String paymentId,
        BigDecimal amount,
        String currency,
        String paymentMethod
) {} 