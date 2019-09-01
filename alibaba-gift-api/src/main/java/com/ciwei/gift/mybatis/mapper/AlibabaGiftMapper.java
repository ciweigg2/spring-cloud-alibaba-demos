package com.ciwei.gift.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ciwei.gift.mybatis.model.AlibabaGift;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @NAME AlibabaGiftMapper
 * @USER Ciwei
 * @DATE 2019/9/1 20:01
 **/
public interface AlibabaGiftMapper extends BaseMapper<AlibabaGift> {
	int updateBatch(List<AlibabaGift> list);

	int batchInsert(@Param("list") List<AlibabaGift> list);

	int insertOrUpdate(AlibabaGift record);

	int insertOrUpdateSelective(AlibabaGift record);
}