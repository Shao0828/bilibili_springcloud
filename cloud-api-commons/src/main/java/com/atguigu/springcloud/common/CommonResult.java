package com.atguigu.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: CommonResult
 * @Description: TODO
 * @Author: shaos
 * @Date: 2021/12/17 10:10
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<E> implements Serializable {

    private String code;
    private String message;
    private E data;


    public CommonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 返回成功
     *
     * @param data 实际对象
     */
    public static <E> CommonResult<E> success(E data) {
        return new CommonResult("200", "操作成功", data);
    }

    /**
     * 返回自定义错误
     *
     * @param code message
     */
    public static CommonResult customFail(String code, String message) {
        return new CommonResult(code, message, null);
    }
}
