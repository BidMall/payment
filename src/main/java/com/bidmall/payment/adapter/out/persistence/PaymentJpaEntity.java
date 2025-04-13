package com.bidmall.payment.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Payment JPA 엔티티
 */
@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq_generator")
    @SequenceGenerator(name = "payment_seq_generator", sequenceName = "payment_seq", allocationSize = 1)
    private Long id;
    private Long userId;
    private Long productId;
    private Long auctionId;
    private BigDecimal amount;
    private String currency;
    private String paymentMethod;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 