package com.bidmall.payment.adapter.in.web;

import com.bidmall.payment.application.port.in.ProcessPaymentUseCase;
import com.bidmall.payment.application.port.in.ProcessPaymentUseCase.ProcessPaymentCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
                new ProcessPaymentUseCase.ProcessPaymentCommand(
                        request.userId,
                        request.productId,
                        request.auctionId,
                        request.amount,
                        request.currency,
                        request.paymentMethod
                )
        );

        return ResponseEntity.ok(new PaymentResponse(paymentId));
    }

    /**
     * 결제 요청 DTO
     */
    public record PaymentRequest(
            @NotNull(message = "userId는 필수 항목입니다.")
            Long userId,
            
            @NotNull(message = "productId는 필수 항목입니다.")
            Long productId,
            
            @NotNull(message = "auctionId는 필수 항목입니다.")
            Long auctionId,
            
            @NotNull(message = "결제 금액은 필수 항목입니다.")
            @DecimalMin(value = "0.01", message = "결제 금액은 0보다 커야 합니다.")
            BigDecimal amount,
            
            @NotBlank(message = "통화는 필수 항목입니다.")
            String currency,
            
            @NotBlank(message = "결제 방법은 필수 항목입니다.")
            String paymentMethod
    ) {}

    /**
     * 결제 응답 DTO
     */
    public record PaymentResponse(
            Long paymentId
    ) {}
} 