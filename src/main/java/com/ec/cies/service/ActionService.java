package com.ec.cies.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ec.cies.pojo.Action;
import com.ec.cies.utils.PageUtils;

import java.util.Map;

public interface ActionService extends IService<Action> {
    PageUtils queryPage(Map<String, Object> params);
}
