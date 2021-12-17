package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: OrderConsController
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 16:21
 * @Version: 1.0
 */
@RestController
public class OrderConsController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://localhost:8001/cloud-payment-service";

    @GetMapping(value = "/consumer/payment/createOrder")
    public CommonResult createOrder(PaymentVO paymentVO) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/createOrder", paymentVO, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getOrderById/{id}")
    public CommonResult getOrderById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getOrderById/" + id, CommonResult.class);
    }

}
