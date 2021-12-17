package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.PaymentVO;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: PaymentController
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 10:06
 * @Version: 1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping(value = "/getOrderById/{id}")
    public CommonResult getOrderById(@PathVariable("id") Long id) {
        PaymentVO orderById = paymentService.getOrderById(id);
        log.info("热部署test" + "11111111111111111111");
        log.info("热部署test" + "11111111111111111111");
        if (null != orderById) {
            return CommonResult.success(orderById);
        } else {
            return CommonResult.customFail("1", "查无此单号");
        }
    }


    @PostMapping(value = "/createOrder")
    public CommonResult createOrder(@RequestBody PaymentVO paymentVO) {
        int order = paymentService.createOrder(paymentVO);
        if (order > 0) {
            return CommonResult.success(order);
        } else {
            return CommonResult.customFail("1", "创建订单失败");
        }
    }


}
