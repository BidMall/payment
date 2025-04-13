package com.bidmall.payment.application.port.out.dto;

/**
 * 결제 게이트웨이 응답 DTO
 */
public record PaymentGatewayResponse(
    boolean successful,
    String transactionId,
    String message
) {} 