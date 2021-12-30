package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: PaymentApplication8001
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/16 17:22
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(PaymentMain8002.class));
    }
}
