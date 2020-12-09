package com.ec.cies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.Role;
import com.ec.cies.service.RoleService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/add")
    @ApiOperation("添加角色")
    public R save(@RequestBody Role pojo){
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name",pojo.getRoleName());
        int count = roleService.count(queryWrapper);
        if (count > 0) {
            return R.error("角色已存在");
        }
        pojo.setRoleId(null);
        roleService.save(pojo);
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation("获取角色列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roleService.queryPage(params);
        return R.ok().put("data", page);
    }

    @PostMapping("/update")
    @ApiOperation("更新角色")
    public R update(@RequestBody Role pojo){
        boolean result = roleService.updateById(pojo);
        if (!result) {
            return R.error("更新失败");
        }
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("单个删除角色")
    public R delete(@PathVariable("id") Long id){
        boolean result = roleService.removeById(id);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除角色")
    public R batchDelete(@RequestBody List<Long> ids){
        boolean result = roleService.removeByIds(ids);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }
}
