package com.rocketmq.demo2.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单实体
 *
 * @author Ciwei
 */
@Data
public class Order implements Serializable {

	private Long orderId;

	private String orderNo;

}
