package com.ec.cies.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.LongListTypeHandler;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "user",autoResultMap = true)
@ApiModel
public class User {
    @TableId
    private Long userId;

    private String userName;

    private String roleName;

    private String userPwd;

    @TableField(typeHandler = LongListTypeHandler.class)
    private List<Long> userRight;

}
