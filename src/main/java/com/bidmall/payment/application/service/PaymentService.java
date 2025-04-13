package com.bidmall.payment.application.service;

import com.bidmall.payment.application.port.in.ProcessPaymentUseCase;
import com.bidmall.payment.application.port.in.dto.ProcessPaymentCommand;
import com.bidmall.payment.application.port.out.LoadPaymentPort;
import com.bidmall.payment.application.port.out.PaymentGatewayPort;
import com.bidmall.payment.application.port.out.SavePaymentPort;
import com.bidmall.payment.application.port.out.dto.PaymentGatewayResponse;
import com.bidmall.payment.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 결제 처리 서비스 구현체
 */
@Service
@RequiredArgsConstructor
public class PaymentService implements ProcessPaymentUseCase {

    private final SavePaymentPort savePaymentPort;
    private final LoadPaymentPort loadPaymentPort;
    private final PaymentGatewayPort paymentGatewayPort;

    @Override
    @Transactional
    public Long processPayment(ProcessPaymentCommand command) {
        // 결제 엔티티 생성
        Payment payment = Payment.create(
                command.userId(),
                command.productId(),
                command.auctionId(),
                command.amount(),
                command.currency(),
                command.paymentMethod()
        );

        // 결제 엔티티 저장 (PENDING 상태)
        Payment savedPayment = savePaymentPort.savePayment(payment);

        // 결제 게이트웨이를 통한 실제 결제 요청
        PaymentGatewayResponse response = paymentGatewayPort.requestPayment(
                savedPayment.getId(),
                savedPayment.getAmount(),
                savedPayment.getCurrency(),
                savedPayment.getPaymentMethod()
        );

        // 결제 결과에 따른 상태 변경
        Payment updatedPayment = response.successful()
                ? savedPayment.markAsSucceeded()
                : savedPayment.markAsFailed();

        // 변경된 결제 상태 저장
        Payment finalPayment = savePaymentPort.savePayment(updatedPayment);

        return finalPayment.getId();
    }
} 