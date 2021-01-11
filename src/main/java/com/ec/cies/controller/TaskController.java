package com.ec.cies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.Task;
import com.ec.cies.pojo.Task;
import com.ec.cies.service.TaskService;
import com.ec.cies.service.TaskService;
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
@RequestMapping("/task")
@Api(tags = "任务管理")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/add")
    @ApiOperation("添加任务")
    public R save(@RequestBody Task pojo){
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_name",pojo.getTaskName());
        int count = taskService.count(queryWrapper);
        if (count > 0) {
            return R.error("任务已存在");
        }
        pojo.setCreateTime(new Date());
        taskService.save(pojo);
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation("获取任务列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = taskService.queryPage(params);
        return R.ok().put("data", page);
    }

    @PostMapping("/update")
    @ApiOperation("更新任务")
    public R update(@RequestBody Task pojo){
        boolean result = taskService.updateById(pojo);
        if (!result) {
            return R.error("更新失败");
        }
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("单个删除任务")
    public R delete(@PathVariable("id") Long id){
        boolean result = taskService.removeById(id);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除任务")
    public R batchDelete(@RequestBody List<Long> ids){
        boolean result = taskService.removeByIds(ids);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }
}
