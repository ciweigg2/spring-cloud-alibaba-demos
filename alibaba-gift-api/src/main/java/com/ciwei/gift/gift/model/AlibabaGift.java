package com.ciwei.gift.gift.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @NAME AlibabaGift
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:05
 **/
@ApiModel(value = "com.ciwei.alibaba.gift.model.AlibabaGift")
@Data
@TableName(value = "alibaba_gift")
public class AlibabaGift implements Serializable {
    /**
     * 礼物id
     */
    @TableId(value = "gift_id", type = IdType.INPUT)
    @ApiModelProperty(value = "礼物id")
    private Long giftId;

    /**
     * 礼物名称
     */
    @TableField(value = "gift_name")
    @ApiModelProperty(value = "礼物名称")
    private String giftName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}