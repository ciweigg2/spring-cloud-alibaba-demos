package com.ciwei.user.dto;

import com.ciwei.gift.mybatis.model.AlibabaGift;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @NAME GetAlibabaUserDto
 * @USER Ciwei
 * @DATE 2019/9/1 20:11
 **/
@Data
public class GetAlibabaUserDto implements Serializable {

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 礼物列表
	 */
	private List<AlibabaGift> alibabaGiftList = Lists.newArrayList();

}
