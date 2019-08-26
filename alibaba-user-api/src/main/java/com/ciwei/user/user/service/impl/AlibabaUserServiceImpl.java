package com.ciwei.user.user.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ciwei.user.user.mapper.AlibabaUserMapper;
import com.ciwei.user.user.model.AlibabaUser;
import java.util.List;
import com.ciwei.user.user.service.AlibabaUserService;
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
