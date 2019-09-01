package com.ciwei.live.controller;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.live.mybatis.model.AlibabaLive;
import com.ciwei.live.mybatis.service.AlibabaLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @NAME LiveController
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:02
 * @menu 直播服务模块
 **/
@RestController
@RequestMapping(value = "/live")
public class LiveController {

    @Autowired
    private AlibabaLiveService alibabaLiveService;

    /**
     * @author 如果没有你
     * @date 2019/8/29 16:15
     * @description 查询所有直播
     * @param alibabaLive: 直播查询条件
     * @status 已发布
     * @menu 直播服务模块/直播相关接口
     * @return {@link ResponseMessage< List< AlibabaLive>>}
     **/
    @PostMapping(value = "/selectAlibabaLives")
    public ResponseMessage<List<AlibabaLive>> selectAlibabaGifts(@RequestBody AlibabaLive alibabaLive){
        return ResponseMessage.success(alibabaLiveService.query().list());
    }

}
