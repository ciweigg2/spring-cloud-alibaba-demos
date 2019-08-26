package com.ciwei.gift.gift.service;

import java.util.List;
import com.ciwei.gift.gift.model.AlibabaGift;
import com.baomidou.mybatisplus.extension.service.IService;
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
