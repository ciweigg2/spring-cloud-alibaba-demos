package com.ciwei.gift.gift.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ciwei.gift.gift.model.AlibabaGift;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @NAME AlibabaGiftMapper
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:05
 **/
public interface AlibabaGiftMapper extends BaseMapper<AlibabaGift> {
    int updateBatch(List<AlibabaGift> list);

    int batchInsert(@Param("list") List<AlibabaGift> list);

    int insertOrUpdate(AlibabaGift record);

    int insertOrUpdateSelective(AlibabaGift record);
}