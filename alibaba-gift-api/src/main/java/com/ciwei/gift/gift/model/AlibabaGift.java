package com.ciwei.gift.gift.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @NAME AlibabaGift
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:05
 **/
@Data
@TableName(value = "alibaba_gift")
public class AlibabaGift implements Serializable {
    /**
     * 礼物id
     */
    @TableId(value = "gift_id", type = IdType.INPUT)
    private Long giftId;

    /**
     * 礼物名称
     */
    @TableField(value = "gift_name")
    private String giftName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}