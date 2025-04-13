package com.bidmall.payment.domain.model;

/**
 * 환불 상태를 나타내는 열거형
 */
public enum RefundStatus {
    PENDING,    // 환불 대기 중
    SUCCEEDED,  // 환불 성공
    FAILED      // 환불 실패
} 