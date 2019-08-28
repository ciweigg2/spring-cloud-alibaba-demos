package com.ciwei.live.live.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** 
 * @NAME AlibabaLive
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
@Data
@TableName(value = "alibaba_live")
public class AlibabaLive implements Serializable {
    /**
     * 直播id
     */
    @TableId(value = "live_id", type = IdType.INPUT)
    private Long liveId;

    /**
     * 直播名称
     */
    @TableField(value = "live_name")
    private String liveName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}