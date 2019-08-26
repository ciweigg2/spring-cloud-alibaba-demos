package com.ciwei.gift.controller;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.gift.gift.model.AlibabaGift;
import com.ciwei.gift.gift.service.AlibabaGiftService;
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
@RequestMapping(value = "/gift")
public class GiftController {

    @Autowired
    private AlibabaGiftService alibabaGiftService;

    @RequestMapping(value = "/selectAlibabaGifts")
    public ResponseMessage<List<AlibabaGift>> selectAlibabaGifts() throws Exception {
        return ResponseMessage.success(alibabaGiftService.query().list());
    }

}
