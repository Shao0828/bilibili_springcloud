package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.PaymentVO;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PaymentServiceImpl
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 10:05
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int createOrder(PaymentVO paymentVO) {
        return paymentDao.createOrder(paymentVO);
    }

    @Override
    public PaymentVO getOrderById(Long id) {
        return paymentDao.getOrderById(id);
    }
}
