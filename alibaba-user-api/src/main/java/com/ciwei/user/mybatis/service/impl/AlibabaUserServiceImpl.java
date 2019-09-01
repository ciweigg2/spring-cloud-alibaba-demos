package com.ciwei.user.mybatis.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ciwei.user.mybatis.mapper.AlibabaUserMapper;
import com.ciwei.user.mybatis.model.AlibabaUser;
import com.ciwei.user.mybatis.service.AlibabaUserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @NAME AlibabaUserServiceImpl
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
@Service
@Transactional(rollbackFor = Exception.class)
public class AlibabaUserServiceImpl extends ServiceImpl<AlibabaUserMapper, AlibabaUser> implements AlibabaUserService{

    @Override
    public int updateBatch(List<AlibabaUser> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<AlibabaUser> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(AlibabaUser record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(AlibabaUser record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
