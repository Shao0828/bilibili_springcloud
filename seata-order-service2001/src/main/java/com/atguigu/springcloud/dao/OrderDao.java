package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: OrderDao
 * @Description: TODO
 * @Author: shaos
 * @Date: 2022/1/14 16:14
 * @Version: 1.0
 */
@Mapper
public interface OrderDao {

    //1 新建订单
    void createOrder(Order order);

    //2 修改订单状态，从零改为1
    void updateStatus(@Param("userId") Long userId, @Param("status") Integer status);
}
