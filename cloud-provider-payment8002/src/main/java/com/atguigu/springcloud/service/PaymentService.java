package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.PaymentVO;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int createOrder(PaymentVO paymentVO);

    public PaymentVO getOrderById(@Param("id") Long id);
}
