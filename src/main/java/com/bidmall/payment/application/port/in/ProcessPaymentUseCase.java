package com.bidmall.payment.application.port.in;

import com.bidmall.payment.application.port.in.dto.ProcessPaymentCommand;

/**
 * 결제 처리를 위한 인바운드 포트(유스케이스)
 */
public interface ProcessPaymentUseCase {
    
    /**
     * 결제 처리 명령
     */
    Long processPayment(ProcessPaymentCommand command);
} 