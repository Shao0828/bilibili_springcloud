package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: OpenFeignMain80
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/28 14:41
 * @Version: 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignMain80 {
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(OpenFeignMain80.class, args));
    }
}
