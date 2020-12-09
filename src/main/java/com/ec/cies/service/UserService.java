package com.ec.cies.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ec.cies.pojo.User;
import com.ec.cies.utils.PageUtils;

import java.util.Map;

public interface UserService extends IService<User> {
    PageUtils queryPage(Map<String, Object> params);
}
