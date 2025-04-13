package com.bidmall.payment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Payment JPA 리포지토리
 */
public interface PaymentRepository extends JpaRepository<PaymentJpaEntity, Long> {
    List<PaymentJpaEntity> findByUserId(Long userId);
    List<PaymentJpaEntity> findByProductId(Long productId);
    List<PaymentJpaEntity> findByAuctionId(Long auctionId);
} 