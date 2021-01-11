package com.ec.cies.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ec.cies.pojo.Case;
import com.ec.cies.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDao extends BaseMapper<Task> {
}
