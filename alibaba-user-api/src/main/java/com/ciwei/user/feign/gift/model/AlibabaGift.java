package com.ciwei.user.feign.gift.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @NAME 礼物服务模块feign
 * @USER Ciwei
 * @DATE 2019/9/1 19:40
 **/
@Data
public class AlibabaGift implements Serializable {

	/**
	 * 礼物id
	 */
	private Long giftId;

	/**
	 * 礼物名称
	 */
	private String giftName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 用户id
	 */
	private Long userId;

}
