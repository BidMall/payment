package com.bidmall.payment.application.port.in.dto;

import java.math.BigDecimal;

/**
 * 환불 처리 명령 DTO
 */
public record ProcessRefundCommand(
    Long paymentId,
    BigDecimal amount,
    String reason
) {
    public ProcessRefundCommand {
        if (paymentId == null) {
            throw new IllegalArgumentException("Payment ID must not be null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
} 