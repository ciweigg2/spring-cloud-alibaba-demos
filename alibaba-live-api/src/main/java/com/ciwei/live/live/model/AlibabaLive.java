package com.ciwei.live.live.model;

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
 * @NAME AlibabaLive
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
@ApiModel(value="com.ciwei.live.live.model.AlibabaLive")
@Data
@TableName(value = "alibaba_live")
public class AlibabaLive implements Serializable {
    /**
     * 直播id
     */
    @TableId(value = "live_id", type = IdType.INPUT)
    @ApiModelProperty(value="直播id")
    private Long liveId;

    /**
     * 直播名称
     */
    @TableField(value = "live_name")
    @ApiModelProperty(value="直播名称")
    private String liveName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}