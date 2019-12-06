package com.rocketmq.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
