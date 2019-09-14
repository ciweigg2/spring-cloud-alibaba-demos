package com.ciwei.user.service;

import com.ciwei.common.request.GetAlibabaUserRequest;
import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.user.dto.GetAlibabaUserDto;
import com.ciwei.user.mybatis.model.AlibabaUser;

/**
 * @NAME UserService
 * @USER Ciwei
 * @DATE 2019/9/7 16:22
 **/
public interface UserService {

	boolean insertUser(AlibabaUser alibabaUser);

	ResponseMessage<GetAlibabaUserDto> getAlibabaUser(GetAlibabaUserRequest getAlibabaUserRequest);

}
