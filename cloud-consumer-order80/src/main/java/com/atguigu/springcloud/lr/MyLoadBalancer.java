package com.atguigu.springcloud.lr;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: MyLoadBalancer
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/28 10:02
 * @Version: 1.0
 */
@Component //需要跟主启动类同包，或者在其子孙包下。
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int currnt;
        int next;

        do {
            currnt = this.atomicInteger.get();
            next = currnt >= 2147483647 ? 0 : currnt + 1;
        } while (!this.atomicInteger.compareAndSet(currnt, next));
        System.out.println("**********" + next);
        return next;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int requestTime = getAndIncrement();
        int serviceSize = serviceInstances.size();
        if (requestTime == 0 || serviceSize == 0) {
            return null;
        }
        int index = requestTime % serviceSize;

        return serviceInstances.get(index);
    }
}
