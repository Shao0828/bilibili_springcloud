package com.atguigu.springcloud.service;

/**
 * @ClassName: StorageService
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/17 10:11
 * @Version: 1.0
 */
public interface StorageService {
    void decreaseStorage(Long productId, Integer count);
}
