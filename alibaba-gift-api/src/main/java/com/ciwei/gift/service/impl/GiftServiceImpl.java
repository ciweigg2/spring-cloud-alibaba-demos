package com.ciwei.gift.service.impl;

import com.ciwei.gift.mybatis.model.AlibabaGift;
import com.ciwei.gift.mybatis.service.AlibabaGiftService;
import com.ciwei.gift.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @NAME GiftServiceImpl
 * @USER Ciwei
 * @DATE 2019/9/7 16:25
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class GiftServiceImpl implements GiftService {

	@Autowired
	private AlibabaGiftService alibabaGiftService;

	@Override
	public boolean insertGift(AlibabaGift alibabaGift) {
		return alibabaGiftService.save(alibabaGift);
	}

}
