package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.PaymentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: PaymentService
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/14 14:20
 * @Version: 1.0
 */
@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<PaymentVO> paymentSQL(@PathVariable("id") Long id);
}
