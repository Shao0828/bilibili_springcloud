package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfigZK
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/23 10:47
 * @Version: 1.0
 */
@Configuration
public class ApplicationContextConfigZK {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
