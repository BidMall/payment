package com.bidmall.payment.application.port.in;

import java.math.BigDecimal;

/**
 * 결제 처리를 위한 인바운드 포트(유스케이스)
 */
public interface ProcessPaymentUseCase {
    
    /**
     * 결제 처리 명령
     */
    Long processPayment(ProcessPaymentCommand command);
    
    /**
     * 결제 처리 명령 DTO
     */
    record ProcessPaymentCommand(
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
} 