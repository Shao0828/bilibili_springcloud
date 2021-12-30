package com.atguigu.springcloud.test;

import java.time.ZonedDateTime;

/**
 * @ClassName: T2
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/30 10:05
 * @Version: 1.0
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

    }
}
