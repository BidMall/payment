package com.bidmall.payment.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Refund 도메인 엔티티
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class Refund {
    private final Long id;
    private final Long paymentId;
    private final BigDecimal amount;
    private final String reason;
    private final RefundStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    // 팩토리 메소드
    public static Refund create(Long paymentId, BigDecimal amount, String reason) {
        return Refund.builder()
            .id(null) // ID는 저장 시 생성 (DB 시퀀스 사용)
            .paymentId(paymentId)
            .amount(amount)
            .reason(reason)
            .status(RefundStatus.PENDING)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    }
    
    // 비즈니스 로직 메소드
    public Refund markAsSucceeded() {
        return toBuilder()
            .status(RefundStatus.SUCCEEDED)
            .updatedAt(LocalDateTime.now())
            .build();
    }

    public Refund markAsFailed() {
        return toBuilder()
            .status(RefundStatus.FAILED)
            .updatedAt(LocalDateTime.now())
            .build();
    }
} 