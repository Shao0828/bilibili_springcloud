package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: GateWayMain9527
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/29 16:05
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(GateWayMain9527.class, args));
    }
}
