package com.bidmall.payment.adapter.out.external.dto;

import java.math.BigDecimal;

/**
 * 외부 환불 게이트웨이 요청 객체
 */
public record RefundRequest(
        String paymentId,
        String refundId,
        BigDecimal amount
) {} 