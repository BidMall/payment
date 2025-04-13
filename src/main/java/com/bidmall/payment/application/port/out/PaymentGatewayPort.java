package com.bidmall.payment.application.port.out;

import com.bidmall.payment.application.port.out.dto.PaymentGatewayResponse;

import java.math.BigDecimal;

/**
 * 외부 결제 게이트웨이와의 통신을 위한 아웃바운드 포트
 */
public interface PaymentGatewayPort {
    
    /**
     * 결제 요청
     */
    PaymentGatewayResponse requestPayment(
        Long paymentId,
        BigDecimal amount, 
        String currency, 
        String paymentMethod
    );
    
    /**
     * 환불 요청
     */
    PaymentGatewayResponse requestRefund(
        Long paymentId,
        Long refundId,
        BigDecimal amount
    );
} 