package com.bidmall.payment.adapter.out.persistence;

import com.bidmall.payment.application.port.out.LoadPaymentPort;
import com.bidmall.payment.application.port.out.PaymentRepositoryPort;
import com.bidmall.payment.application.port.out.SavePaymentPort;
import com.bidmall.payment.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 결제 관련 데이터 영속성 어댑터
 * 아웃바운드 어댑터 역할을 합니다.
 */
@Component
@RequiredArgsConstructor
public class PaymentPersistenceAdapter implements SavePaymentPort, LoadPaymentPort, PaymentRepositoryPort {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Payment savePayment(Payment payment) {
        PaymentJpaEntity paymentJpaEntity = paymentMapper.mapToJpaEntity(payment);
        PaymentJpaEntity savedEntity = paymentRepository.save(paymentJpaEntity);
        return paymentMapper.mapToDomainEntity(savedEntity);
    }

    @Override
    public Optional<Payment> loadPayment(Long id) {
        return paymentRepository.findById(id)
                .map(paymentMapper::mapToDomainEntity);
    }
    
    @Override
    public List<Payment> loadPaymentsByUserId(Long userId) {
        return paymentRepository.findByUserId(userId).stream()
                .map(paymentMapper::mapToDomainEntity)
                .toList();
    }
    
    @Override
    public List<Payment> loadPaymentsByProductId(Long productId) {
        return paymentRepository.findByProductId(productId).stream()
                .map(paymentMapper::mapToDomainEntity)
                .toList();
    }
    
    @Override
    public List<Payment> loadPaymentsByAuctionId(Long auctionId) {
        return paymentRepository.findByAuctionId(auctionId).stream()
                .map(paymentMapper::mapToDomainEntity)
                .toList();
    }
    
    @Override
    public Payment save(Payment payment) {
        return savePayment(payment);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return loadPayment(id);
    }
    
    @Override
    public List<Payment> findByUserId(Long userId) {
        return loadPaymentsByUserId(userId);
    }
    
    @Override
    public List<Payment> findByProductId(Long productId) {
        return loadPaymentsByProductId(productId);
    }
    
    @Override
    public List<Payment> findByAuctionId(Long auctionId) {
        return loadPaymentsByAuctionId(auctionId);
    }
} 