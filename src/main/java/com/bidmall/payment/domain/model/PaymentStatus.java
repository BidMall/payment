package com.bidmall.payment.domain.model;

/**
 * 결제 상태를 나타내는 열거형
 */
public enum PaymentStatus {
    PENDING,     // 결제 대기 중
    SUCCEEDED,   // 결제 성공
    FAILED,      // 결제 실패
    CANCELLED    // 결제 취소
} 