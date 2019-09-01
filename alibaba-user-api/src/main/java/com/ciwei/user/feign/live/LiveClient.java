package com.ciwei.user.feign.live;

import com.ciwei.common.utils.ResponseMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @NAME GiftClient
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:55
 **/
@FeignClient("alibaba-live-provider")
public interface LiveClient {

    @RequestMapping(value = "/gift/selectAlibabaLives")
    ResponseMessage selectAlibabaLives();

}
