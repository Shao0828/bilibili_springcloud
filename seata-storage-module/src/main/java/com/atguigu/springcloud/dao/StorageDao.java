package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: StorageDao
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/17 9:58
 * @Version: 1.0
 */
@Mapper
public interface StorageDao {

    void decreaseStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
