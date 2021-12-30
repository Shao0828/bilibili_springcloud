package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentConsulMain8006
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/24 9:39
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8006 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(PaymentConsulMain8006.class, args));
    }
}
