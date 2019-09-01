package com.ciwei.common.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @NAME GetAlibabaGiftByUserIdRequest
 * @USER Ciwei
 * @DATE 2019/9/1 19:43
 **/
public class GetAlibabaGiftByUserIdRequest implements Serializable {

	/**
	 * 用户id
	 */
	@Getter
	@Setter
	private Long userId;

}
