package com.ciwei.live.mybatis.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @NAME AlibabaLive
 * @USER Ciwei
 * @DATE 2019/9/1 20:00
 **/
@Data
@TableName(value = "alibaba_live")
public class AlibabaLive implements Serializable {
	/**
	 * 直播id
	 */
	@TableId(value = "live_id", type = IdType.INPUT)
	private Long liveId;

	/**
	 * 直播名称
	 */
	@TableField(value = "live_name")
	private String liveName;

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

	public static final String COL_LIVE_ID = "live_id";

	public static final String COL_LIVE_NAME = "live_name";

	public static final String COL_USER_ID = "user_id";

	public static final String COL_CREATE_TIME = "create_time";
}