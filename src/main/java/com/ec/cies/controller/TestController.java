package com.ec.cies.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.Test;
import com.ec.cies.service.TestService;
import com.ec.cies.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.sql.Wrapper;

@RestController
public class TestController {

    @Autowired
    TestService testService;
    @PostMapping("/test")
    R test(@RequestBody Test test){
        System.out.println(test.getName());
        System.out.println(test.getType());
        testService.save(test);
//        testService.getOne(new QueryWrapper<Test>().eq("name",test.getName()));
        return R.ok().put("test",testService.getOne(new QueryWrapper<Test>().eq("name",test.getName())));
    }
}
