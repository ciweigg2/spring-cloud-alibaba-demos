package com.ciwei.user.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciwei.common.request.GetAlibabaUserRequest;
import com.ciwei.common.utils.MybatisPlusPage;
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

    GetAlibabaUserDto getAlibabaUser(GetAlibabaUserRequest getAlibabaUserRequest);

    IPage<AlibabaUser> selectPage(MybatisPlusPage<AlibabaUser> mybatisPlusPage);

}
