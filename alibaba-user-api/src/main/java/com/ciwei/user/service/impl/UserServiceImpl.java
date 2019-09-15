package com.ciwei.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ciwei.common.request.GetAlibabaGiftByUserIdRequest;
import com.ciwei.common.request.GetAlibabaUserRequest;
import com.ciwei.common.utils.MybatisPlusPage;
import com.ciwei.common.utils.SnowflakeIdWorker;
import com.ciwei.gift.mybatis.model.AlibabaGift;
import com.ciwei.gift.service.GiftService;
import com.ciwei.user.dto.GetAlibabaUserDto;
import com.ciwei.user.mybatis.model.AlibabaUser;
import com.ciwei.user.mybatis.service.AlibabaUserService;
import com.ciwei.user.service.UserService;
import com.google.common.base.Preconditions;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private SnowflakeIdWorker snowflakeIdWorker;

    @Reference
    private GiftService giftService;

    @Override
    @HystrixCommand(fallbackMethod = "getFallback")
    @GlobalTransactional
    public boolean insertUser(AlibabaUser alibabaUser) {
        Long uid = snowflakeIdWorker.nextId();
        alibabaUser.setUserId(uid);
        alibabaUser.setUserName("我爱G.E.M邓紫棋");
        alibabaUserService.save(alibabaUser);
        AlibabaGift alibabaGift = new AlibabaGift();
        alibabaGift.setUserId(uid);
        alibabaGift.setGiftId(snowflakeIdWorker.nextId());
        alibabaGift.setGiftName("我爱G.E.M邓紫棋");
        giftService.insertGift(alibabaGift);
        //模拟异常
//		int a = 1/0;
        return true;
    }

    public boolean getFallback(AlibabaUser alibabaUser) throws TransactionException {
        System.out.println("测试熔断后回滚事务");
        //事务不接受try catch 和熔断后的 所以需要手动回滚
        String xid = GlobalTransactionContext.getCurrentOrCreate().getXid();
        GlobalTransactionContext.reload(xid).rollback();
        return false;
    }

    @Override
    public GetAlibabaUserDto getAlibabaUser(GetAlibabaUserRequest getAlibabaUserRequest) {
        //应该在service完成的 但是查询也不涉及事务 所以无所谓了
        GetAlibabaUserDto getAlibabaUserDto = new GetAlibabaUserDto();
        GetAlibabaGiftByUserIdRequest getAlibabaGiftByUserIdRequest = new GetAlibabaGiftByUserIdRequest();
        getAlibabaGiftByUserIdRequest.setUserId(getAlibabaUserRequest.getUserId());
        List<AlibabaGift> alibabaGiftList = giftService.getAlibabaGiftByUserId(getAlibabaGiftByUserIdRequest);
        getAlibabaUserDto.setAlibabaGiftList(alibabaGiftList);
        //查询用户信息
        AlibabaUser alibabaUser = alibabaUserService.getById(getAlibabaUserRequest.getUserId());
        //判断用户是否为空
        Preconditions.checkNotNull(alibabaUser, "未查询到用户");
        getAlibabaUserDto.setUserId(alibabaUser.getUserId());
        getAlibabaUserDto.setUserName(alibabaUser.getUserName());
        getAlibabaUserDto.setCreateTime(alibabaUser.getCreateTime());
        return getAlibabaUserDto;
    }

    @Override
    public IPage<AlibabaUser> selectPage(MybatisPlusPage<AlibabaUser> mybatisPlusPage) {
        QueryWrapper<AlibabaUser> wrapper = new QueryWrapper();
        //根据不为空的字段查询
        wrapper.setEntity(mybatisPlusPage.getObject());
        Page<AlibabaUser> page = new Page<>(mybatisPlusPage.getCurrent() ,mybatisPlusPage.getSize());
        return alibabaUserService.page(page ,wrapper);
    }

}
