package com.ciwei.user.service.impl;

import com.ciwei.common.request.GetAlibabaGiftByUserIdRequest;
import com.ciwei.common.utils.SnowflakeIdWorker;
import com.ciwei.user.feign.gift.GiftClient;
import com.ciwei.user.mybatis.model.AlibabaUser;
import com.ciwei.user.mybatis.service.AlibabaUserService;
import com.ciwei.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @NAME UserServiceImpl
 * @USER Ciwei
 * @DATE 2019/9/7 16:22
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private AlibabaUserService alibabaUserService;

	@Autowired
	private GiftClient giftClient;

	@Override
	@HystrixCommand(fallbackMethod="getFallback")
	public boolean insertUser(AlibabaUser alibabaUser) {
		SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1, 1);
		GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest = new GetAlibabaGiftByUserIdRequest();
		getAlibabaGiftByUserIdRequest.setUserId(snowflakeIdWorker.nextId());
		alibabaUser.setUserId(snowflakeIdWorker.nextId());
		alibabaUser.setUserName("我爱姜忆薇");
		alibabaUserService.save(alibabaUser);
		giftClient.insertGift(getAlibabaGiftByUserIdRequest);
		//模拟异常
		int a = 1/0;
		return true;
	}

	public boolean getFallback(AlibabaUser alibabaUser) {
		System.out.println("测试熔断后回滚事务");
		return false;
	}

}
