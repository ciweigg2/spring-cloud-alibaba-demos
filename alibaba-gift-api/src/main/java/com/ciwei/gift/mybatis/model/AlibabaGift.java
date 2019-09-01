package com.ciwei.gift.mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @NAME AlibabaGift
 * @USER Ciwei
 * @DATE 2019/9/1 20:01
 **/
@Data
@TableName(value = "alibaba_gift")
public class AlibabaGift implements Serializable {
	/**
	 * 礼物id
	 */
	@TableId(value = "gift_id", type = IdType.INPUT)
	private Long giftId;

	/**
	 * 礼物名称
	 */
	@TableField(value = "gift_name")
	private String giftName;

	/**
	 * 用户id
	 */
	@TableField(value = "user_id")
	private Long userId;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	private Date createTime;

	private static final long serialVersionUID = 1L;

	public static final String COL_GIFT_ID = "gift_id";

	public static final String COL_GIFT_NAME = "gift_name";

	public static final String COL_USER_ID = "user_id";

	public static final String COL_CREATE_TIME = "create_time";
}