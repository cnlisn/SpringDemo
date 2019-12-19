package com.lisn.demo.service.impl;

import com.lisn.demo.core.universal.AbstractService;
import com.lisn.demo.dao.db1.UserInfoMapper;
import com.lisn.demo.model.UserInfo;
import com.lisn.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: UserInfoService接口实现类
* @author SG
* @date 2019/12/19 10:43
*/
@Service
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

}