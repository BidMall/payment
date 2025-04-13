package com.bidmall.payment.application.port.out;

import com.bidmall.payment.domain.model.Payment;
import java.util.List;
import java.util.Optional;

/**
 * 결제 정보 조회를 위한 아웃바운드 포트
 */
public interface LoadPaymentPort {
    Optional<Payment> loadPayment(Long id);
    List<Payment> loadPaymentsByUserId(Long userId);
    List<Payment> loadPaymentsByProductId(Long productId);
    List<Payment> loadPaymentsByAuctionId(Long auctionId);
} 