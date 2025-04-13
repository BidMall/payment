package com.bidmall.payment.application.port.in.dto;

import java.math.BigDecimal;

/**
 * 결제 처리 명령 DTO
 */
public record ProcessPaymentCommand(
    Long userId,
    Long productId,
    Long auctionId,
    BigDecimal amount, 
    String currency, 
    String paymentMethod
) {
    public ProcessPaymentCommand {
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }
        if (productId == null) {
            throw new IllegalArgumentException("Product ID must not be null");
        }
        // auctionId는 경매가 아닌 경우 null 허용
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency must not be empty");
        }
        if (paymentMethod == null || paymentMethod.isBlank()) {
            throw new IllegalArgumentException("Payment method must not be empty");
        }
    }
} 