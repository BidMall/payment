package com.bidmall.payment.adapter.out.external;

import com.bidmall.payment.adapter.out.external.dto.PaymentRequest;
import com.bidmall.payment.adapter.out.external.dto.PaymentResponse;
import com.bidmall.payment.adapter.out.external.dto.RefundRequest;
import com.bidmall.payment.adapter.out.external.dto.RefundResponse;
import com.bidmall.payment.application.port.out.PaymentGatewayPort;
import com.bidmall.payment.application.port.out.dto.PaymentGatewayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 외부 결제 게이트웨이 어댑터
 * 아웃바운드 어댑터 역할을 합니다.
 */
@Component
@RequiredArgsConstructor
public class PaymentGatewayAdapter implements PaymentGatewayPort {

    // 외부 결제 게이트웨이 클라이언트
    private final ExternalPaymentGatewayClient gatewayClient;

    @Override
    public PaymentGatewayResponse requestPayment(
            Long paymentId,
            BigDecimal amount,
            String currency,
            String paymentMethod) {
        
        // 외부 결제 게이트웨이 요청 객체 생성
        PaymentRequest request = new PaymentRequest(
                paymentId.toString(),
                amount,
                currency,
                paymentMethod
        );
        
        // 외부 결제 게이트웨이 호출
        PaymentResponse response = gatewayClient.processPayment(request);
        
        // 외부 응답을 내부 포트 응답으로 변환
        return new PaymentGatewayResponse(
                response.isSuccess(),
                response.getTransactionId(),
                response.getMessage()
        );
    }

    @Override
    public PaymentGatewayResponse requestRefund(
            Long paymentId,
            Long refundId,
            BigDecimal amount) {
        
        // 외부 환불 게이트웨이 요청 객체 생성
        RefundRequest request = new RefundRequest(
                paymentId.toString(),
                refundId.toString(),
                amount
        );
        
        // 외부 환불 게이트웨이 호출
        RefundResponse response = gatewayClient.processRefund(request);
        
        // 외부 응답을 내부 포트 응답으로 변환
        return new PaymentGatewayResponse(
                response.isSuccess(),
                response.getTransactionId(),
                response.getMessage()
        );
    }
} 