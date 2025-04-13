package com.bidmall.payment.adapter.out.external.dto;

/**
 * 외부 결제 게이트웨이 응답 객체
 */
public record PaymentResponse(
        boolean success,
        String transactionId,
        String message
) {
    public boolean isSuccess() {
        return success;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMessage() {
        return message;
    }
} 