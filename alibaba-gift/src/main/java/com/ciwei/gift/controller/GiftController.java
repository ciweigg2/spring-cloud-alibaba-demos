package com.ciwei.gift.controller;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.gift.gift.model.AlibabaGift;
import com.ciwei.gift.gift.service.AlibabaGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @NAME GiftController
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:02
 * @menu 礼物服务接口
 **/
@RestController
@RequestMapping(value = "/gift")
public class GiftController {

    @Autowired
    private AlibabaGiftService alibabaGiftService;

    /**
     * @author 如果没有你
     * @date 2019/8/29 16:07
     * @description 查询所有礼物
     * @param alibabaGift: 礼物查询条件
     * @return {@link ResponseMessage< List< AlibabaGift>>}
     **/
    @PostMapping(value = "/selectAlibabaGifts")
    public ResponseMessage<List<AlibabaGift>> selectAlibabaGifts(@RequestBody AlibabaGift alibabaGift) throws Exception {
        return ResponseMessage.success(alibabaGiftService.query().list());
    }

}
