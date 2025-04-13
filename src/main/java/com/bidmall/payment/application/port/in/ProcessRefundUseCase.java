package com.bidmall.payment.application.port.in;

import com.bidmall.payment.application.port.in.dto.ProcessRefundCommand;

/**
 * 환불 처리를 위한 인바운드 포트(유스케이스)
 */
public interface ProcessRefundUseCase {
    
    /**
     * 환불 처리 명령
     */
    Long processRefund(ProcessRefundCommand command);
} 