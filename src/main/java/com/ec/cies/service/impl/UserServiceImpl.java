package com.ec.cies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ec.cies.dao.UserDao;
import com.ec.cies.pojo.Device;
import com.ec.cies.pojo.User;
import com.ec.cies.service.UserService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(User.class, info -> !info.getColumn().equals("user_pwd"));
        if (params.containsKey("keyword") && !params.get("keyword").equals("")){
            queryWrapper.like("user_name",params.get("keyword"));
            queryWrapper.or().like("role_name",params.get("keyword"));
        }
        IPage<User> page = this.page(
                new Query<User>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }
}
