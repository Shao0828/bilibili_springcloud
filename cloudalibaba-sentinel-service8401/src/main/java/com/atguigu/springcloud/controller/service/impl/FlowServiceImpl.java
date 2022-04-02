package com.atguigu.springcloud.controller.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.controller.service.FlowLimitService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: FlowServiceImpl
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/13 13:02
 * @Version: 1.0
 */
@Service
public class FlowServiceImpl implements FlowLimitService {
    @Override
    @SentinelResource("commons")
    public String commons() {
        return "------commons";
    }
}
