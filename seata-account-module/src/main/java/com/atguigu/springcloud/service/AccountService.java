package com.atguigu.springcloud.service;

import java.math.BigDecimal;

/**
 * @ClassName: AccountService
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/17 10:59
 * @Version: 1.0
 */
public interface AccountService {

    void decreaseAccount(Long userId, BigDecimal money);
}
