package com.bidmall.payment.adapter.out.persistence;

import com.bidmall.payment.domain.model.Payment;
import com.bidmall.payment.domain.model.PaymentStatus;
import org.springframework.stereotype.Component;

/**
 * 도메인 엔티티와 JPA 엔티티 간의 매핑을 담당하는 매퍼
 */
@Component
public class PaymentMapper {

    /**
     * 도메인 엔티티를 JPA 엔티티로 변환
     */
    public PaymentJpaEntity mapToJpaEntity(Payment payment) {
        return PaymentJpaEntity.builder()
                .id(payment.getId())
                .orderId(payment.getOrderId())
                .customerId(payment.getCustomerId())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .paymentMethod(payment.getPaymentMethod())
                .status(payment.getStatus().name())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }

    /**
     * JPA 엔티티를 도메인 엔티티로 변환
     */
    public Payment mapToDomainEntity(PaymentJpaEntity paymentJpaEntity) {
        return Payment.builder()
                .id(paymentJpaEntity.getId())
                .orderId(paymentJpaEntity.getOrderId())
                .customerId(paymentJpaEntity.getCustomerId())
                .amount(paymentJpaEntity.getAmount())
                .currency(paymentJpaEntity.getCurrency())
                .paymentMethod(paymentJpaEntity.getPaymentMethod())
                .status(PaymentStatus.valueOf(paymentJpaEntity.getStatus()))
                .createdAt(paymentJpaEntity.getCreatedAt())
                .updatedAt(paymentJpaEntity.getUpdatedAt())
                .build();
    }
} 