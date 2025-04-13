package com.bidmall.payment.adapter.in.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * 결제 요청 DTO
 */
public record PaymentRequest(
        @NotNull(message = "userId는 필수 항목입니다.")
        Long userId,
        
        @NotNull(message = "productId는 필수 항목입니다.")
        Long productId,
        
        @NotNull(message = "auctionId는 필수 항목입니다.")
        Long auctionId,
        
        @NotNull(message = "결제 금액은 필수 항목입니다.")
        @DecimalMin(value = "0.01", message = "결제 금액은 0보다 커야 합니다.")
        BigDecimal amount,
        
        @NotBlank(message = "통화는 필수 항목입니다.")
        String currency,
        
        @NotBlank(message = "결제 방법은 필수 항목입니다.")
        String paymentMethod
) {} 