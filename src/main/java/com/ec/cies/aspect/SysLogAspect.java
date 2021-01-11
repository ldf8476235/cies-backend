package com.ec.cies.aspect;

import com.ec.cies.utils.HttpContextUtils;
import com.ec.cies.utils.TokenUtils;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

//@Aspect
//@Component
public class SysLogAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Pointcut("execution(* com.ec.cies.controller.*.*(..))")
//    public void logPointCut() {
//
//    }

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        logger.info("<---------Start--------->");
        MethodSignature signature = (MethodSignature) point.getSignature();
        String userName = TokenUtils.getTokenUserName();
        logger.info("请求用户:"+ userName);
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        logger.info("IP地址:"+ HttpContextUtils.getIPAddress());
        logger.info("请求地址:"+ httpServletRequest.getRequestURI());
        Method method = signature.getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String desc = apiOperation.value();
        logger.info("功能描述:"+ desc);
        Object[] args = point.getArgs();
        try{
            String params = new Gson().toJson(args);
            logger.info("请求参数:"+ params);
        }catch (Exception e){

        }
        //执行方法
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        if(result.toString().length()<1000){
            logger.info("返回参数:" + result.toString());
        }else{
            logger.info("返回参数长度:" + result.toString().length());
        }
        logger.info("<---------End("+time+"ms)--------->",time);
        return result;
    }
}
