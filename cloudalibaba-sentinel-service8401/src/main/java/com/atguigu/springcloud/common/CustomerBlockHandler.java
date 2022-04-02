package com.atguigu.springcloud.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return CommonResult.customFail("" + 4444, "按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return CommonResult.customFail("" + 4444, "按客戶自定义,global handlerException----2");
    }
}
