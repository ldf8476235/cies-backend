package com.ec.cies.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.Device;
import com.ec.cies.service.DeviceService;
import com.ec.cies.utils.PageUtils;
import com.ec.cies.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/device")
@Api(tags = "设备管理")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/add")
    @ApiOperation("添加设备")
    public R save(@RequestBody Device device){
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("device_name",device.getDeviceName());
        int count = deviceService.count(queryWrapper);
        if (count > 0) {
            return R.error("设备已存在");
        }
        device.setDeviceId(null);
        deviceService.save(device);
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("单个删除设备")
    public R delete(@PathVariable("id") Long deviceId){
        boolean result = deviceService.removeById(deviceId);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }

    @PostMapping("/batchDelete")
    @ApiOperation("批量删除设备")
    public R batchDelete(@RequestBody List<Long> deviceIds){
        boolean result = deviceService.removeByIds(deviceIds);
        if (!result) {
            return R.error("删除失败");
        }
        return R.ok();
    }

    @PostMapping("/update")
    @ApiOperation("更新设备")
    public R update(@RequestBody Device device){
        boolean result = deviceService.updateById(device);
        if (!result) {
            return R.error("更新失败");
        }
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation("获取设备列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceService.queryPage(params);
        return R.ok().put("data", page);
    }
}
