package com.ec.cies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ec.cies.dao.ActionDao;
import com.ec.cies.pojo.Action;
import com.ec.cies.pojo.Action;
import com.ec.cies.service.ActionService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActionServiceImpl extends ServiceImpl<ActionDao, Action> implements ActionService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<Action> queryWrapper = new QueryWrapper<>();
        if (params.containsKey("start_time")){
            queryWrapper.apply("date_format (create_time,'%Y-%m-%d %H:%i:%s') >= date_format('" + params.get("start_time") + "','%Y-%m-%d %H:%i:%s')");
            queryWrapper.apply("date_format (create_time,'%Y-%m-%d %H:%i:%s') <= date_format('" + params.get("end_time") + "','%Y-%m-%d %H:%i:%s')");
            params.remove("start_time");
            params.remove("end_time");
        }
        params.forEach((key, value) -> {
            if (!key.equals("page") && !key.equals("limit")) {
                queryWrapper.like(key,value);
            }
        });
        IPage<Action> page = this.page(
                new Query<Action>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }
}
