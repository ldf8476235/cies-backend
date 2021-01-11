package com.ec.cies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.Action;
import com.ec.cies.service.ActionService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/action")
@Api(tags = "动作管理")
public class ActionController {
    @Autowired
    ActionService actionService;

    @PostMapping("/add")
    @ApiOperation("添加动作")
    public R save(@RequestBody Action pojo){
        QueryWrapper<Action> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("action_name",pojo.getActionName());
        int count = actionService.count(queryWrapper);
        if (count > 0) {
            return R.error("动作已存在");
        }
        pojo.setCreateTime(new Date());
        pojo.setUpdateTime(new Date());
        actionService.save(pojo);
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation("获取动作列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = actionService.queryPage(params);
        return R.ok().put("data", page);
    }

    @PostMapping("/update")
    @ApiOperation("更新动作")
    public R update(@RequestBody Action pojo){
        pojo.setUpdateTime(new Date());
        boolean result = actionService.updateById(pojo);
        if (!result) {
            return R.error("更新失败");
        }
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("单个删除动作")
    public R delete(@PathVariable("id") Long id){
        boolean result = actionService.removeById(id);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除动作")
    public R batchDelete(@RequestBody List<Long> ids){
        boolean result = actionService.removeByIds(ids);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }
}
