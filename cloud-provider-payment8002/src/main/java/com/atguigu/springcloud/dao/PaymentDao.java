package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.PaymentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 9:46
 * @Version: 1.0
 */
@Mapper
//@Repository不用Spring的
public interface PaymentDao {

    public int createOrder(PaymentVO paymentVO);

    public PaymentVO getOrderById(@Param("id") Long id);
}
