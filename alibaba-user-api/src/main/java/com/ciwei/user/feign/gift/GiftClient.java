package com.ciwei.user.feign.gift;

import com.ciwei.common.request.GetAlibabaGiftByUserIdRequest;
import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.user.feign.gift.model.AlibabaGift;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @NAME GiftClient
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:55
 **/
@FeignClient("alibaba-gift-provider")
public interface GiftClient {

    @PostMapping(value = "/gift/selectAlibabaGifts")
    ResponseMessage selectAlibabaGifts();

    @GetMapping(value = "/gift/getAlibabaGiftByUserId")
    List<AlibabaGift> getAlibabaGiftByUserId(@SpringQueryMap GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest);

}
