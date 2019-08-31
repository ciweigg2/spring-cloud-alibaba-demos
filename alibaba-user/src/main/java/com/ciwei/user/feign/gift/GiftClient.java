package com.ciwei.user.feign.gift;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.gift.gift.model.AlibabaGift;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @NAME GiftClient
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:55
 **/
@FeignClient("alibaba-gift-provider")
public interface GiftClient {

    @PostMapping(value = "/gift/selectAlibabaGifts")
    ResponseMessage selectAlibabaGifts();

    @GetMapping(value = "/gift/selectAlibabaGiftByIdGiftId")
    ResponseMessage<AlibabaGift> selectAlibabaGiftByIdGiftId(@SpringQueryMap AlibabaGift alibabaGift);

}
