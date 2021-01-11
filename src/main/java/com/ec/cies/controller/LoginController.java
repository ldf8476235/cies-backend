package com.ec.cies.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ec.cies.pojo.User;
import com.ec.cies.service.TokenService;
import com.ec.cies.service.UserService;
import com.ec.cies.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public R login(@RequestBody Map<String, String> params){
        String userName = params.get("userName");
        User user = userService.getOne(new QueryWrapper<User>().eq("user_name",userName));
        if (user == null) {
            return R.error("用户不存在");
        }
        String passWord = DigestUtils.md5DigestAsHex(params.get("passWord").getBytes());
        if (!passWord.equals(user.getUserPwd())) {
            return R.error("密码错误");
        }
        logger.info("用户("+user.getUserName()+")已登录");
        String token = tokenService.getToken(user);
        user.setUserStatus(1);
        user.setUserToken(token);
        userService.updateById(user);
        user.setUserPwd(null);
        return R.ok().put("user",user).put("token",token);
    }

    @GetMapping("logout/{id}")
    public R logout(@PathVariable("id") Long id){
        User user = userService.getById(id);
//        user.setUserToken(null);
        user.setUserStatus(0);
        userService.updateById(user);
        logger.info("用户("+user.getUserName()+")已退出");
        return R.ok();
    }
}
