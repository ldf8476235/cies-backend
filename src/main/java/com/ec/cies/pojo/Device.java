package com.ec.cies.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.StringListTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "device",autoResultMap = true)
@ApiModel
public class Device {
    @TableId
    @ApiModelProperty(value = "设备Id")
    private Long deviceId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "负责人")
    private String deviceAdmin;

    @ApiModelProperty(value = "IP地址")
    private String deviceIp;

    @ApiModelProperty(value = "端口号")
    private Integer devicePort;

    @TableField(typeHandler = StringListTypeHandler.class)
    @ApiModelProperty(value = "类型")
    private List<String> deviceType;

    @ApiModelProperty(value = "状态")
    private Integer deviceStatus;

    @ApiModelProperty(value = "挂载设备")
    private String deviceMount;

    @ApiModelProperty(value = "执行机描述")
    private String deviceDesc;

}
