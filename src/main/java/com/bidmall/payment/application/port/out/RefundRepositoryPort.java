package com.bidmall.payment.application.port.out;

import com.bidmall.payment.domain.model.Refund;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Refund 리포지토리 아웃바운드 포트
 */
public interface RefundRepositoryPort {
    Refund save(Refund refund);
    Optional<Refund> findById(Long id);
    List<Refund> findByPaymentId(Long paymentId);
} 