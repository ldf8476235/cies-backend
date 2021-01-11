package com.ec.cies.pojo;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.JsonArrayHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "task",autoResultMap = true)
@ApiModel
public class Task {
    @TableId
    @ApiModelProperty(value = "ID")
    private Long taskId;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "所属项目")
    private String taskProject;

    @ApiModelProperty(value = "状态",hidden = true)
    private String taskStatus;

    @ApiModelProperty(value = "进度",hidden = true)
    private int taskProgress;

    @ApiModelProperty(value = "指派人")
    private String taskAssign;

    @ApiModelProperty(value = "软件版本")
    private String taskVersion;

    @ApiModelProperty(value = "任务描述")
    private String taskDesc;

    @ApiModelProperty(value = "创建时间",hidden = true)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "用例")
    @TableField(typeHandler = JsonArrayHandler.class)
    private JSONArray taskCase;
}
