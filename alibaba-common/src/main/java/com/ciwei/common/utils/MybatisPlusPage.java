package com.ciwei.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 马秀成
 * @date 2019/8/29
 * @jdk.version 1.8
 * @desc 封装mybatisplus分页
 */
@Data
public class MybatisPlusPage<T> implements Serializable {

    /**
     * 对象
     */
    private T object;

    /**
     * 每页条数
     */
    private long size;

    /**
     * 当前页数
     */
    private long current;

}
