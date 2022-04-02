package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/14 16:24
 * @Version: 1.0
 */
public interface OrderService {
    void createOrder(Order order);
}
