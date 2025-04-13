package com.bidmall.payment.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Payment 도메인 엔티티
 */
@Getter
@Builder(access = AccessLevel.PUBLIC)
public class Payment {
    private final Long id;
    private final Long userId;
    private final Long productId;
    private final Long auctionId;
    private final BigDecimal amount;
    private final String currency;
    private final String paymentMethod;
    private final PaymentStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    // 팩토리 메소드
    public static Payment create(Long userId, Long productId, Long auctionId,
                               BigDecimal amount, String currency, String paymentMethod) {
        return Payment.builder()
            .id(null) // ID는 저장 시 생성 (DB 시퀀스 사용)
            .userId(userId)
            .productId(productId)
            .auctionId(auctionId)
            .amount(amount)
            .currency(currency)
            .paymentMethod(paymentMethod)
            .status(PaymentStatus.PENDING)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    }

    // 비즈니스 로직 메소드
    public Payment markAsSucceeded() {
        return toBuilder()
            .status(PaymentStatus.SUCCEEDED)
            .updatedAt(LocalDateTime.now())
            .build();
    }

    public Payment markAsFailed() {
        return toBuilder()
            .status(PaymentStatus.FAILED)
            .updatedAt(LocalDateTime.now())
            .build();
    }
} 