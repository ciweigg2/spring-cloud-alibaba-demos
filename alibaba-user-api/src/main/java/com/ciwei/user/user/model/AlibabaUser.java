package com.ciwei.user.user.model;

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
 * @NAME AlibabaUser
 * @USER Ciwei
 * @DATE 2019/8/26/026 12:30
**/
@ApiModel(value="com.ciwei.user.user.model.AlibabaUser")
@Data
@TableName(value = "alibaba_user")
public class AlibabaUser implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value="用户名")
    private String userName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}