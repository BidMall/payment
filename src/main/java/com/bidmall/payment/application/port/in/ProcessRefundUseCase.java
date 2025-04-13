package com.bidmall.payment.application.port.in;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 환불 처리를 위한 인바운드 포트(유스케이스)
 */
public interface ProcessRefundUseCase {
    
    /**
     * 환불 처리 명령
     */
    UUID processRefund(ProcessRefundCommand command);
    
    /**
     * 환불 처리 명령 DTO
     */
    record ProcessRefundCommand(
        UUID paymentId,
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
} 