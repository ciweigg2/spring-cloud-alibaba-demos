package com.ciwei.live.live.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ciwei.live.live.model.AlibabaLive;
import java.util.List;
import com.ciwei.live.live.mapper.AlibabaLiveMapper;
import com.ciwei.live.live.service.AlibabaLiveService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @NAME AlibabaLiveServiceImpl
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class AlibabaLiveServiceImpl extends ServiceImpl<AlibabaLiveMapper, AlibabaLive> implements AlibabaLiveService{

    @Override
    public int updateBatch(List<AlibabaLive> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<AlibabaLive> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(AlibabaLive record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(AlibabaLive record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
