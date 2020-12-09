package com.ec.cies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ec.cies.dao.RoleDao;
import com.ec.cies.pojo.Device;
import com.ec.cies.pojo.Role;
import com.ec.cies.service.RoleService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (params.containsKey("keyword") && !params.get("keyword").equals("")){
            queryWrapper.like("role_name",params.get("keyword"));
            queryWrapper.or().like("role_desc",params.get("keyword"));
        }
        IPage<Role> page = this.page(
                new Query<Role>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }
}
