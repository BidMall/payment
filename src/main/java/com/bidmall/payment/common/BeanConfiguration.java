package com.bidmall.payment.common;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션 빈 설정
 */
@Configuration
@EnableFeignClients(basePackages = "com.bidmall.payment.adapter.out.external")
public class BeanConfiguration {
    // RestTemplate 빈 제거, OpenFeign 사용
} 