package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.PaymentVO;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private String serverPort;//添加serverPort

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/getOrderById/{id}")
    public CommonResult getOrderById(@PathVariable("id") Long id) {
        PaymentVO orderById = paymentService.getOrderById(id);
        if (null != orderById) {
//            return CommonResult.success(orderById);
            return new CommonResult("200", "查询成功，serverPort ->:" + serverPort, orderById);
        } else {
            return CommonResult.customFail("1", "查无此单号");
        }
    }


    @PostMapping(value = "/createOrder")
    public CommonResult createOrder(@RequestBody PaymentVO paymentVO) {
        int order = paymentService.createOrder(paymentVO);
        if (order > 0) {
            return new CommonResult("200", "创建订单成功，serverPort ->:" + serverPort, order);
        } else {
            return CommonResult.customFail("1", "创建订单失败");
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****element: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getServerPortLB() {
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to here, O(∩_∩)O哈哈~";
    }
}
