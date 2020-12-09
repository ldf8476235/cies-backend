package com.ec.cies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.Role;
import com.ec.cies.pojo.User;
import com.ec.cies.service.RoleService;
import com.ec.cies.service.UserService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public R save(@RequestBody User pojo){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",pojo.getUserName());
        int count = userService.count(queryWrapper);
        if (count > 0) {
            return R.error("用户已存在");
        }
        //添加权限信息
        Role role = roleService.getOne(new QueryWrapper<Role>().eq("role_name",pojo.getRoleName()));
        pojo.setUserRight(role.getRoleType());
        pojo.setUserId(null);
        pojo.setUserPwd(DigestUtils.md5DigestAsHex(pojo.getUserPwd().getBytes()));
        userService.save(pojo);
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation("获取用户列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);
        return R.ok().put("data", page);
    }

    @PostMapping("/update")
    @ApiOperation("更新用户")
    public R update(@RequestBody User pojo){
        //获取权限信息
        Role role = roleService.getOne(new QueryWrapper<Role>().eq("role_name",pojo.getRoleName()));
        pojo.setUserRight(role.getRoleType());
        pojo.setUserPwd(DigestUtils.md5DigestAsHex(pojo.getUserPwd().getBytes()));
        boolean result = userService.updateById(pojo);
        if (!result) {
            return R.error("更新失败");
        }
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("单个删除用户")
    public R delete(@PathVariable("id") Long id){
        boolean result = userService.removeById(id);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除用户")
    public R batchDelete(@RequestBody List<Long> ids){
        boolean result = userService.removeByIds(ids);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }
}
