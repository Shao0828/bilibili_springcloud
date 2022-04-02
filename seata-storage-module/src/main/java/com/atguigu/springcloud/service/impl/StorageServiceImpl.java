package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StorageServiceImpl
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/17 10:12
 * @Version: 1.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decreaseStorage(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decreaseStorage(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}
