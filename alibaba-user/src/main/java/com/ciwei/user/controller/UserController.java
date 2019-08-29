package com.ciwei.user.controller;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.user.feign.gift.GiftClient;
import com.ciwei.user.properties.UserProperties;
import com.ciwei.user.user.model.AlibabaUser;
import com.ciwei.user.user.service.AlibabaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @NAME GiftController
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

}
