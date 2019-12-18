package com.lisn.demo.controller;

import com.lisn.demo.core.ret.RetResponse;
import com.lisn.demo.core.ret.RetResult;
import com.lisn.demo.service.RedisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * redis测试接口
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    @PostMapping("/setRedis")
    public RetResult<String> setRedis(String key,String value) {
        redisService.set(key,value);
        return RetResponse.makeOKRsp(value);
    }

    @PostMapping("/getRedis")
    public RetResult<String> getRedis(String key) {
        String name = redisService.get(key);
        return RetResponse.makeOKRsp(name);
    }


}