package com.ciwei.gift.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ciwei.common.request.GetAlibabaGiftByUserIdRequest;
import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.common.utils.SnowflakeIdWorker;
import com.ciwei.gift.mybatis.model.AlibabaGift;
import com.ciwei.gift.mybatis.service.AlibabaGiftService;
import com.ciwei.gift.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @NAME GiftController
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:02
 * @menu 礼物服务模块
 **/
@RestController
@RequestMapping(value = "/gift")
public class GiftController {

    @Autowired
    private AlibabaGiftService alibabaGiftService;

    @Autowired
    private GiftService giftService;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    /**
     * @author 如果没有你
     * @date 2019/8/29 16:07
     * @description 查询所有礼物
     * @param alibabaGift: 礼物查询条件
     * @status 已发布
     * @menu 礼物服务模块/礼物相关接口
     * @return {@link ResponseMessage< List< AlibabaGift>>}
     **/
    @PostMapping(value = "/selectAlibabaGifts")
    public ResponseMessage<List<AlibabaGift>> selectAlibabaGifts(@RequestBody AlibabaGift alibabaGift) {
        return ResponseMessage.success(alibabaGiftService.query().list());
    }

    /**
     * @author 如果没有你
     * @date 2019/8/29 16:07
     * @description 根据giftId查询礼物
     * @param alibabaGift: 礼物giftId
     * @status 已发布
     * @menu 礼物服务模块/礼物相关接口
     * @return {@link ResponseMessage<AlibabaGift>}
     **/
    @GetMapping(value = "/selectAlibabaGiftByIdGiftId")
    public ResponseMessage<AlibabaGift> selectAlibabaGiftByIdGiftId(AlibabaGift alibabaGift) {
        return ResponseMessage.success(alibabaGiftService.getById(alibabaGift.getGiftId()));
    }

    /**
     * @author 如果没有你
     * @date 2019/9/01 19:13
     * @description 根据userId查询礼物列表
     * @param getAlibabaGiftByUserIdRequest: userId
     * @status 已发布
     * @menu 礼物服务模块/RPC
     * @return {@link ResponseMessage<AlibabaGift>}
     **/
    @GetMapping(value = "/getAlibabaGiftByUserId")
    public List<AlibabaGift> getAlibabaGiftByUserId(GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest) {
        AlibabaGift alibabaGift = new AlibabaGift();
        alibabaGift.setUserId(getAlibabaGiftByUserIdRequest.getUserId());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(alibabaGift);
        return alibabaGiftService.getBaseMapper().selectList(queryWrapper);
    }

    /**
     * @author 如果没有你
     * @date 2019/9/01 19:13
     * @description 测试lcn分布式事务
     * @param getAlibabaGiftByUserIdRequest: userId
     * @status 已发布
     * @menu 礼物服务模块/RPC
     * @return {@link ResponseMessage<AlibabaGift>}
     **/
    @PostMapping(value = "/insertGift")
    public boolean insertGift(@RequestBody GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest) {
        AlibabaGift alibabaGift = new AlibabaGift();
        alibabaGift.setUserId(getAlibabaGiftByUserIdRequest.getUserId());
        alibabaGift.setGiftId(snowflakeIdWorker.nextId());
        alibabaGift.setGiftName("我爱G.E.M邓紫棋");
        return giftService.insertGift(alibabaGift);
    }

}
