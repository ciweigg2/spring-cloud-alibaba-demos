package com.ciwei.user.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ciwei.user.mybatis.model.AlibabaUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * @NAME AlibabaUserMapper
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
public interface AlibabaUserMapper extends BaseMapper<AlibabaUser> {
    int updateBatch(List<AlibabaUser> list);

    int batchInsert(@Param("list") List<AlibabaUser> list);

    int insertOrUpdate(AlibabaUser record);

    int insertOrUpdateSelective(AlibabaUser record);
}