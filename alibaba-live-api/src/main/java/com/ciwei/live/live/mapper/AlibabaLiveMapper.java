package com.ciwei.live.live.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ciwei.live.live.model.AlibabaLive;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * @NAME AlibabaLiveMapper
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
public interface AlibabaLiveMapper extends BaseMapper<AlibabaLive> {
    int updateBatch(List<AlibabaLive> list);

    int batchInsert(@Param("list") List<AlibabaLive> list);

    int insertOrUpdate(AlibabaLive record);

    int insertOrUpdateSelective(AlibabaLive record);
}