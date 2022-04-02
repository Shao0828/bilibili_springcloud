package com.atguigu.springcloud.service;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.PaymentVO;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PaymentServiceImpl
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/14 14:26
 * @Version: 1.0
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public CommonResult<PaymentVO> paymentSQL(Long id) {
        return new CommonResult<>(44444 + "", "服务降级返回,---PaymentFallbackService", new PaymentVO(id, "errorSerial"));
    }
}
