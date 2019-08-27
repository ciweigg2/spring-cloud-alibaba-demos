package com.ciwei.live.controller;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.live.live.model.AlibabaLive;
import com.ciwei.live.live.service.AlibabaLiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "/live")
@Api(tags = "直播服务" ,description = "直播接口")
public class LiveController {

    @Autowired
    private AlibabaLiveService alibabaLiveService;

    @GetMapping(value = "/selectAlibabaLives")
    @ApiOperation(value = "查询直播", notes="查询全部")
    public ResponseMessage<List<AlibabaLive>> selectAlibabaGifts(){
        return ResponseMessage.success(alibabaLiveService.query().list());
    }

}
