package com.ciwei.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ciwei.common.utils.MyIPage;
import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.user.feign.gift.GiftClient;
import com.ciwei.user.properties.UserProperties;
import com.ciwei.user.user.model.AlibabaUser;
import com.ciwei.user.user.service.AlibabaUserService;
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
 * @menu 用户服务接口
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
    private UserProperties userProperties;

    /**
     * @author 如果没有你
     * @date 2019/8/29 16:01
     * @description 查询所有用户
     * @param alibabaUser: 用户查询条件
     * @return {@link ResponseMessage< List< AlibabaUser>>}
     **/
    @PostMapping(value = "/selectAlibabaUsers")
    public ResponseMessage<List<AlibabaUser>> selectAlibabaGifts(@RequestBody AlibabaUser alibabaUser) {
        return ResponseMessage.success(alibabaUserService.query().list());
    }

    /**
     * @author 如果没有你
     * @date 2019/8/29 17:03
     * @description 分页查询用户信息
     * @param mybatisPlusPage: 分页查询条件 {"current":"1","size":"2","object":{}}
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

}
