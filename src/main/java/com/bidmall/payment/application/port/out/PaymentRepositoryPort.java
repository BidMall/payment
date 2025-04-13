package com.bidmall.payment.application.port.out;

import com.bidmall.payment.domain.model.Payment;
import java.util.List;
import java.util.Optional;

/**
 * Payment 리포지토리 아웃바운드 포트
 */
public interface PaymentRepositoryPort {
    Payment save(Payment payment);
    Optional<Payment> findById(Long id);
    List<Payment> findByUserId(Long userId);
    List<Payment> findByProductId(Long productId);
    List<Payment> findByAuctionId(Long auctionId);
}