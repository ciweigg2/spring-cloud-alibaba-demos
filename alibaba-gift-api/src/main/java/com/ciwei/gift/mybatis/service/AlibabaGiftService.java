package com.ciwei.gift.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ciwei.gift.mybatis.model.AlibabaGift;

import java.util.List;
    /** 
 * @NAME AlibabaGiftService
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:05
**/
public interface AlibabaGiftService extends IService<AlibabaGift>{


    int updateBatch(List<AlibabaGift> list);

    int batchInsert(List<AlibabaGift> list);

    int insertOrUpdate(AlibabaGift record);

    int insertOrUpdateSelective(AlibabaGift record);

}
