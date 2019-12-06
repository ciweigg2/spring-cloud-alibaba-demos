package com.ciwei.user.service;

import com.ciwei.user.mybatis.model.AlibabaUser;

/**
 * @NAME UserService
 * @USER Ciwei
 * @DATE 2019/9/7 16:22
 **/
public interface UserService {

	boolean insertUser(AlibabaUser alibabaUser);

	boolean insertUserRocketMQ(AlibabaUser alibabaUser);
}
