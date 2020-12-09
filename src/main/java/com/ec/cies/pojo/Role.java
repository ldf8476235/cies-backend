package com.ec.cies.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.LongListTypeHandler;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "role",autoResultMap = true)
@ApiModel
public class Role {
    @TableId
    private Long roleId;

    private String roleName;

    private String roleDesc;

    @TableField(typeHandler = LongListTypeHandler.class)
    private List<Long> roleType;
}
