package com.ec.cies.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ec.cies.pojo.Device;
import com.ec.cies.pojo.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceDao extends BaseMapper<Device> {
}
