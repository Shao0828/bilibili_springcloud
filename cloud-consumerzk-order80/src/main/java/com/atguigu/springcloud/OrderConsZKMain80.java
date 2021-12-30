package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: OrderConsZKMain80
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/23 10:41
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsZKMain80 {

    public static void main(String[] args) {
        System.out.println(SpringApplication.run(OrderConsZKMain80.class, args));
    }
}
