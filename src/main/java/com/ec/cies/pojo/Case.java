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
@TableName(value = "cases",autoResultMap = true)
@ApiModel
public class Case {
    @TableId
    @ApiModelProperty(value = "ID")
    private Long caseId;

    @ApiModelProperty(value = "用例名称")
    private String caseName;

    @TableField(typeHandler = StringListTypeHandler.class)
    @ApiModelProperty(value = "引用",hidden = true)
    private List<String> caseCite;

    @ApiModelProperty(value = "所属项目")
    private String caseProject;

    @ApiModelProperty(value = "创建人")
    private String caseCreator;

    @ApiModelProperty(value = "软件版本")
    private String caseVersion;

    @ApiModelProperty(value = "创建时间",hidden = true)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间",hidden = true)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "用例描述")
    private String caseDesc;

    @ApiModelProperty(value = "动作")
    @TableField(typeHandler = JsonArrayHandler.class)
    private JSONArray caseAction;

}
