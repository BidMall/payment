package com.bidmall.payment.application.port.out;

import com.bidmall.payment.domain.model.Payment;

/**
 * 결제 정보 저장을 위한 아웃바운드 포트
 */
public interface SavePaymentPort {
    Payment savePayment(Payment payment);
} 