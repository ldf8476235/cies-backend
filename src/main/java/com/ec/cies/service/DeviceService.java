package com.ec.cies.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ec.cies.pojo.Device;
import com.ec.cies.pojo.Test;
import com.ec.cies.utils.PageUtils;

import java.util.Map;

public interface DeviceService extends IService<Device> {
    PageUtils queryPage(Map<String, Object> params);
}
