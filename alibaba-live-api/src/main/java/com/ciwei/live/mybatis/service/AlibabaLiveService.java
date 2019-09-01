package com.ciwei.live.mybatis.service;

import com.ciwei.live.mybatis.model.AlibabaLive;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
    /** 
 * @NAME AlibabaLiveService
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
public interface AlibabaLiveService extends IService<AlibabaLive>{


    int updateBatch(List<AlibabaLive> list);

    int batchInsert(List<AlibabaLive> list);

    int insertOrUpdate(AlibabaLive record);

    int insertOrUpdateSelective(AlibabaLive record);

}
