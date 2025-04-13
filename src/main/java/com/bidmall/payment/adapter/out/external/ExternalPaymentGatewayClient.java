package com.bidmall.payment.adapter.out.external;

import com.bidmall.payment.adapter.out.external.PaymentGatewayAdapter.PaymentRequest;
import com.bidmall.payment.adapter.out.external.PaymentGatewayAdapter.PaymentResponse;
import com.bidmall.payment.adapter.out.external.PaymentGatewayAdapter.RefundRequest;
import com.bidmall.payment.adapter.out.external.PaymentGatewayAdapter.RefundResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 외부 결제 게이트웨이 OpenFeign 클라이언트 인터페이스
 */
@FeignClient(name = "payment-gateway", url = "${payment.gateway.url}")
public interface ExternalPaymentGatewayClient {
    /**
     * 결제 처리 요청
     */
    @PostMapping("/payments")
    PaymentResponse processPayment(@RequestBody PaymentRequest request);
    
    /**
     * 환불 처리 요청
     */
    @PostMapping("/refunds")
    RefundResponse processRefund(@RequestBody RefundRequest request);
} 