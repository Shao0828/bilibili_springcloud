package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: Order80Application
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 16:20
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//添加到此处
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class Order80Application {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(Order80Application.class));
    }
}
