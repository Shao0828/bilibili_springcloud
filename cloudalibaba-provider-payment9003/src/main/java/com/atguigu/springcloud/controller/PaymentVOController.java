package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.PaymentVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentVOController {
    @Value("${server.port}")
    private String serverPort;

    //模拟数据库
    public static HashMap<Long, PaymentVO> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new PaymentVO(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L, new PaymentVO(2L, "bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L, new PaymentVO(3L, "6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<PaymentVO> PaymentVOSQL(@PathVariable("id") Long id) {
        PaymentVO PaymentVO = hashMap.get(id);
        CommonResult<PaymentVO> result = new CommonResult(200 + "", "from mysql,serverPort:  " + serverPort, PaymentVO);
        return result;
    }

}
