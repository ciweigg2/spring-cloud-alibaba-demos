package com.ciwei.gift.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ciwei.common.request.GetAlibabaGiftByUserIdRequest;
import com.ciwei.gift.mybatis.model.AlibabaGift;
import com.ciwei.gift.mybatis.service.AlibabaGiftService;
import com.ciwei.gift.service.GiftService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @NAME GiftServiceImpl
 * @USER Ciwei
 * @DATE 2019/9/7 16:25
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class GiftServiceImpl implements GiftService {

    @Autowired
    private AlibabaGiftService alibabaGiftService;

    @Override
    public boolean insertGift(AlibabaGift alibabaGift) {
        return alibabaGiftService.save(alibabaGift);
    }

    @Override
    public List<AlibabaGift> getAlibabaGiftByUserId(GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest) {
        AlibabaGift alibabaGift = new AlibabaGift();
        alibabaGift.setUserId(getAlibabaGiftByUserIdRequest.getUserId());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(alibabaGift);
        return alibabaGiftService.getBaseMapper().selectList(queryWrapper);
    }

}
