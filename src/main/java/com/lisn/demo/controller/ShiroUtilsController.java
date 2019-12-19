package com.lisn.demo.controller;

import com.lisn.demo.model.UserInfo;
import com.lisn.demo.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("shiroUtils")
public class ShiroUtilsController {

    @GetMapping("/noLogin")
    public void noLogin() {
        throw new UnauthenticatedException();
    }

    @GetMapping("/noAuthorize")
    public void noAuthorize() {
        throw new UnauthorizedException();
    }


    @PostMapping("/getNowUser")
    public UserInfo getNowUser() {
        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return u;
    }

    @Resource
    private ShiroService shiroService;

    /**
     * @throws Exception
     * @Description: 重新加载shiro权限
     */
    @PostMapping("/updatePermission")
    public void updatePermission() throws Exception {
        shiroService.updatePermission();
    }
}