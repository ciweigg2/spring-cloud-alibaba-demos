package com.ciwei.gift.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ciwei.gift.mybatis.mapper.AlibabaGiftMapper;
import com.ciwei.gift.mybatis.model.AlibabaGift;
import com.ciwei.gift.mybatis.service.AlibabaGiftService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @NAME AlibabaGiftServiceImpl
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:05
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class AlibabaGiftServiceImpl extends ServiceImpl<AlibabaGiftMapper, AlibabaGift> implements AlibabaGiftService {

    @Override
    public int updateBatch(List<AlibabaGift> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<AlibabaGift> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(AlibabaGift record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(AlibabaGift record) {
        return baseMapper.insertOrUpdateSelective(record);
    }

}
