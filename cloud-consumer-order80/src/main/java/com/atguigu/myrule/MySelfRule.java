package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MySelfRule
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/27 15:47
 * @Version: 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getIRule() {
        return new RandomRule();
    }
}
