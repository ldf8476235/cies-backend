package com.ec.cies.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import com.ec.cies.pojo.Device;
import com.ec.cies.pojo.Role;
import com.ec.cies.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface RoleService extends IService<Role> {
    PageUtils queryPage(Map<String, Object> params);
}
