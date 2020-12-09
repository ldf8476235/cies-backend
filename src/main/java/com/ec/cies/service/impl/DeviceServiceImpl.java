package com.ec.cies.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ec.cies.dao.DeviceDao;;
import com.ec.cies.pojo.Device;
import com.ec.cies.service.DeviceService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceDao, Device> implements DeviceService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        params.forEach((key, value) -> {
            if (!key.equals("page") && !key.equals("limit")) {
                queryWrapper.like(key,value);
            }
        });
        IPage<Device> page = this.page(
                new Query<Device>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }
}
