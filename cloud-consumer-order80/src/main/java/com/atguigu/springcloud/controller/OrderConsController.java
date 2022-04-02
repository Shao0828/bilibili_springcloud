package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.PaymentVO;
import com.atguigu.springcloud.lr.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @ClassName: OrderConsController
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 16:21
 * @Version: 1.0
 */
@RestController
public class OrderConsController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancer loadBalancer;
    /**
     * 单机状态下  固定url没有问题
     */
//    public static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * todo   集群模式下 要将提供者的地址配置为 Erueka  中的服务名称
     * 注意： 这里需要将RestTempleta 赋予负载均衡的能力
     * 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
     * 否则 会报错java.net.UnknownHostException: CLOUD-PAYMENT-SERVICE
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping(value = "/consumer/payment/createOrder")
    public CommonResult createOrder(PaymentVO paymentVO) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/createOrder", paymentVO, CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/createOrderForEntity")
    public CommonResult createOrder2(PaymentVO paymentVO) {
        ResponseEntity<CommonResult> responseEntity =
                restTemplate.postForEntity(PAYMENT_URL + "/payment/createOrder", paymentVO, CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return CommonResult.customFail("444", "操作失败");
        }
    }


    @GetMapping(value = "/consumer/payment/getOrderById/{id}")
    public CommonResult getOrderById(@PathVariable("id") Long id) {
        URI url = getPaymentLB();
        return restTemplate.getForObject(url + "/payment/getOrderById/" + id, CommonResult.class);
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/getOrderById/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<PaymentVO> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getOrderById/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();//getForObject()
        } else {
            return CommonResult.customFail("444", "操作失败");
        }
    }


    @GetMapping(value = "/consumer/payment/lb")
    public URI getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances.size() <= 0 || instances.isEmpty()) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        System.out.println(uri);
        return uri;
//        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }
    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }

}
