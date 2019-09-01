package com.ciwei.common.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @NAME SelectAlibabaUsersRequest
 * @USER Ciwei
 * @DATE 2019/9/1 20:06
 **/
public class GetAlibabaUserRequest implements Serializable {

	/**
	 * 用户id
	 */
	@Getter
	@Setter
	private Long userId;

}
