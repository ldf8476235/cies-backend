package com.ec.cies.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ec.cies.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
