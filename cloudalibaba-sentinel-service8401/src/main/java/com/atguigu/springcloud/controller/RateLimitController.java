package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.common.CustomerBlockHandler;
import com.atguigu.springcloud.entities.PaymentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200 + "", "按资源名称限流测试OK", new PaymentVO(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return CommonResult.customFail("444", exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200 + "", "按url限流测试OK", new PaymentVO(2020L, "serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler"
            , blockHandlerClass = CustomerBlockHandler.class
            , blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200 + "", "按客戶自定义", new PaymentVO(2020L, "serial003"));
    }
}
