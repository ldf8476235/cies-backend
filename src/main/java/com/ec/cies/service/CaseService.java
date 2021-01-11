package com.ec.cies.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ec.cies.pojo.Case;
import com.ec.cies.utils.PageUtils;

import java.util.Map;

public interface CaseService extends IService<Case> {
    PageUtils queryPage(Map<String, Object> params);
}
