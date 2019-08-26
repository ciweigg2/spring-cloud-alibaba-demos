package com.ciwei.user.user.service;

import com.ciwei.user.user.model.AlibabaUser;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
    /** 
 * @NAME AlibabaUserService
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
public interface AlibabaUserService extends IService<AlibabaUser>{


    int updateBatch(List<AlibabaUser> list);

    int batchInsert(List<AlibabaUser> list);

    int insertOrUpdate(AlibabaUser record);

    int insertOrUpdateSelective(AlibabaUser record);

}
