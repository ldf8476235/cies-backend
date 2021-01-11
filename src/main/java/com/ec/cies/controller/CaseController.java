package com.ec.cies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.Case;
import com.ec.cies.service.CaseService;
import com.ec.cies.utils.DateUtils;
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
@RequestMapping("/case")
@Api(tags = "用例管理")
public class CaseController {

    @Autowired
    CaseService caseService;

    @PostMapping("/add")
    @ApiOperation("添加用例")
    public R save(@RequestBody Case pojo){
        QueryWrapper<Case> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("case_name",pojo.getCaseName());
        int count = caseService.count(queryWrapper);
        if (count > 0) {
            return R.error("用例已存在");
        }
        pojo.setCaseId(null);
        pojo.setCreateTime(new Date());
        pojo.setUpdateTime(new Date());
        caseService.save(pojo);
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation("获取用例列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = caseService.queryPage(params);
        return R.ok().put("data", page);
    }

    @PostMapping("/update")
    @ApiOperation("更新用例")
    public R update(@RequestBody Case pojo){
        pojo.setUpdateTime(new Date());
        boolean result = caseService.updateById(pojo);
        if (!result) {
            return R.error("更新失败");
        }
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("单个删除用例")
    public R delete(@PathVariable("id") Long id){
        boolean result = caseService.removeById(id);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除用例")
    public R batchDelete(@RequestBody List<Long> ids){
        boolean result = caseService.removeByIds(ids);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }
}
