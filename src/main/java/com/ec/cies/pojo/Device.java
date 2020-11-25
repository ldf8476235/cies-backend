package com.ec.cies.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ec.cies.utils.typehandler.ListTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "device",autoResultMap = true)
@ApiModel
public class Device {
    @TableId
    private Long deviceId;

    private String deviceName;

    private String deviceAdmin;

    private String deviceIp;

    private Integer devicePort;

    @TableField(typeHandler = ListTypeHandler.class)
    private List<String> deviceType;

    private Integer deviceStatus;

    private String deviceMount;

    private String deviceDesc;

}
