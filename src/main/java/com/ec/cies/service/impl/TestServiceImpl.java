package com.ec.cies.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ec.cies.dao.TestDao;
import com.ec.cies.pojo.Test;
import com.ec.cies.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestDao, Test> implements TestService {

}
