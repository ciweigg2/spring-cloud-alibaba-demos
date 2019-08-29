package com.ciwei.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 马秀成
 * @date 2019/8/29
 * @jdk.version 1.8
 * @desc 封装mybatisplus分页
 */
@Data
public class MybatisPlusPage<T> extends Page<T> implements Serializable {

    /**
     * 对象
     */
    private T object;

}
