package com.bidmall.payment.adapter.in.web;

import com.bidmall.payment.adapter.in.web.dto.PaymentRequest;
import com.bidmall.payment.adapter.in.web.dto.PaymentResponse;
import com.bidmall.payment.application.port.in.ProcessPaymentUseCase;
import com.bidmall.payment.application.port.in.dto.ProcessPaymentCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 결제 관련 REST API 컨트롤러
 * 인바운드 어댑터 역할을 합니다.
 */
@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final ProcessPaymentUseCase processPaymentUseCase;

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody @Valid PaymentRequest request) {
        Long paymentId = processPaymentUseCase.processPayment(
                new ProcessPaymentCommand(
                        request.userId(),
                        request.productId(),
                        request.auctionId(),
                        request.amount(),
                        request.currency(),
                        request.paymentMethod()
                )
        );

        return ResponseEntity.ok(new PaymentResponse(paymentId));
    }
} 