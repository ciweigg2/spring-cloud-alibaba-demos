package com.ciwei.live.controller;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.live.live.model.AlibabaLive;
import com.ciwei.live.live.service.AlibabaLiveService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LiveController {

    @Autowired
    private AlibabaLiveService alibabaLiveService;

    @RequestMapping(value = "/selectAlibabaLives")
    public ResponseMessage<List<AlibabaLive>> selectAlibabaGifts(){
        return ResponseMessage.success(alibabaLiveService.query().list());
    }

}
