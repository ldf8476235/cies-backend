package com.ec.cies.pojo;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.JsonArrayHandler;
import com.ec.cies.utils.typehandler.StringListTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "action",autoResultMap = true)
@ApiModel
public class Action {
    @TableId
    @ApiModelProperty(value = "ID")
    private Long actionId;

    @ApiModelProperty(value = "动作名称")
    private String actionName;

    @ApiModelProperty(value = "动作类型")
    private int actionType;

    @ApiModelProperty(value = "所属项目")
    private String actionProject;

    @ApiModelProperty(value = "软件版本")
    private String actionVersion;

    @ApiModelProperty(value = "超时时间")
    private int actionTimeout;

    @ApiModelProperty(value = "创建人")
    private String actionCreator;

    @ApiModelProperty(value = "创建时间",hidden = true)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间",hidden = true)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "动作描述")
    private String actionDesc;

    @ApiModelProperty(value = "脚本内容")
    private String actionScript;

    @ApiModelProperty(value = "语料库")
    private String actionCorpus;

    @TableField(typeHandler = StringListTypeHandler.class)
    @ApiModelProperty(value = "引用",hidden = true)
    private List<String> actionCite;

    @ApiModelProperty(value = "屏幕操作/语音输入下的数据")
    @TableField(typeHandler = JsonArrayHandler.class)
    private JSONArray actionData;
}
