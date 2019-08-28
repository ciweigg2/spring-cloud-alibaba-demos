package com.ciwei.user.controller;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.user.feign.gift.GiftClient;
import com.ciwei.user.properties.UserProperties;
import com.ciwei.user.user.model.AlibabaUser;
import com.ciwei.user.user.service.AlibabaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @NAME GiftController
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:02
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

    @GetMapping(value = "/selectAlibabaUsers")
    public ResponseMessage<List<AlibabaUser>> selectAlibabaGifts() {
//        log.info("获取gift的数据：{}" + giftClient.selectAlibabaGifts());
        return ResponseMessage.success(alibabaUserService.query().list());
    }

}
