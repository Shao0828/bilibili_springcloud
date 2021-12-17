package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: PaymentVO
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 9:45
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVO implements Serializable {
    private Long id;
    private String serial;
}
