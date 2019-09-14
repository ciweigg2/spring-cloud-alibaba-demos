package com.ciwei.gift.service;

import com.ciwei.common.request.GetAlibabaGiftByUserIdRequest;
import com.ciwei.gift.mybatis.model.AlibabaGift;

import java.util.List;

/**
 * @NAME GiftService
 * @USER Ciwei
 * @DATE 2019/9/7 16:25
 **/
public interface GiftService {

	boolean insertGift(AlibabaGift alibabaGift);

	List<AlibabaGift> getAlibabaGiftByUserId(GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest);

}
