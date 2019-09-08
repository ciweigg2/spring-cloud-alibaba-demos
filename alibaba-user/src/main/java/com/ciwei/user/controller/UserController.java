package com.ciwei.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ciwei.common.request.GetAlibabaGiftByUserIdRequest;
import com.ciwei.common.request.GetAlibabaUserRequest;
import com.ciwei.common.utils.MyIPage;
import com.ciwei.common.utils.MybatisPlusPage;
import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.user.dto.GetAlibabaUserDto;
import com.ciwei.user.feign.gift.GiftClient;
import com.ciwei.user.feign.gift.model.AlibabaGift;
import com.ciwei.user.mybatis.model.AlibabaUser;
import com.ciwei.user.mybatis.service.AlibabaUserService;
import com.ciwei.user.service.UserService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @NAME UserController
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:02
 * @menu 用户服务模块
 **/
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private AlibabaUserService alibabaUserService;

    @Autowired
    private GiftClient giftClient;

    @Autowired
    private UserService userService;

    /**
     * @author 如果没有你
     * @date 2019/8/29 16:01
     * @description 根据用户id查询用户相关信息
     * @param getAlibabaUserRequest: 用户查询条件
     * @status 已发布
     * @menu 用户服务模块/用户相关接口
     * @return {@link ResponseMessage< List< AlibabaUser>>}
     **/
    @PostMapping(value = "/selectAlibabaUsers")
    public ResponseMessage<GetAlibabaUserDto> getAlibabaUser(@RequestBody GetAlibabaUserRequest getAlibabaUserRequest) {
        //应该在service完成的 但是查询也不涉及事务 所以无所谓了
        GetAlibabaUserDto getAlibabaUserDto = new GetAlibabaUserDto();
        GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest = new GetAlibabaGiftByUserIdRequest();
        getAlibabaGiftByUserIdRequest.setUserId(getAlibabaUserRequest.getUserId());
        List<AlibabaGift> alibabaGiftList = giftClient.getAlibabaGiftByUserId(getAlibabaGiftByUserIdRequest);
        getAlibabaUserDto.setAlibabaGiftList(alibabaGiftList);
        //查询用户信息
        AlibabaUser alibabaUser = alibabaUserService.getById(getAlibabaUserRequest.getUserId());
        //判断用户是否为空
        Preconditions.checkNotNull(alibabaUser ,"未查询到用户");
        getAlibabaUserDto.setUserId(alibabaUser.getUserId());
        getAlibabaUserDto.setUserName(alibabaUser.getUserName());
        getAlibabaUserDto.setCreateTime(alibabaUser.getCreateTime());
        return ResponseMessage.success(getAlibabaUserDto);
    }

    /**
     * @author 如果没有你
     * @date 2019/8/29 17:03
     * @description 分页查询用户信息
     * @param mybatisPlusPage: 分页查询条件 {"current":"1","size":"2","object":{}}
     * @status 开发中
     * @menu 用户服务模块/用户相关接口
     * @return {@link ResponseMessage< MyIPage< AlibabaUser>>}
     **/
    @PostMapping(value = "/selectAlibabaUsersPage")
    public ResponseMessage<MyIPage<AlibabaUser>> selectAlibabaUsersPage(@RequestBody MybatisPlusPage<AlibabaUser> mybatisPlusPage) {
        QueryWrapper<AlibabaUser> wrapper = new QueryWrapper();
        //根据不为空的字段查询
        wrapper.setEntity(mybatisPlusPage.getObject());
        Page<AlibabaUser> page = new Page<>(mybatisPlusPage.getCurrent() ,mybatisPlusPage.getSize());
        return ResponseMessage.success(alibabaUserService.page(page,wrapper));
    }

    /**
     * @author 如果没有你
     * @date 2019/8/29 17:03
     * @description 测试lcn分布式事务
     * @param alibabaUser: 用户对象
     * @status 开发中
     * @menu 用户服务模块/用户相关接口
     * @return {@link ResponseMessage< MyIPage< AlibabaUser>>}
     **/
    @PostMapping(value = "/insertUser")
    public ResponseMessage<Boolean> insertUser(@RequestBody AlibabaUser alibabaUser) {
        return ResponseMessage.success(userService.insertUser(alibabaUser));
    }

}
