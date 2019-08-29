package com.ciwei.common.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @NAME 分页接口显示yapi
 * @USER Ciwei
 * @DATE 2019/8/29 21:15
 **/
@Data
public class MyIPage<T> implements Serializable {

	/**
	 * 总记录数
	 */
	private long total;

	/**
	 * 每页条数
	 */
	private long size;

	/**
	 * 当前页数
	 */
	private long current;

	/**
	 * 总页数
	 */
	private long pages;

	/**
	 * 对象信息
	 */
	private T object;

	/**
	 * 数据列表
	 */
	private List<T> records;

}
