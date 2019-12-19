package com.lisn.demo.service.impl;

import com.lisn.demo.dao.db1.UserRoleMapper;
import com.lisn.demo.model.UserRole;
import com.lisn.demo.service.UserRoleService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: UserRoleService接口实现类
* @author SG
* @date 2019/12/19 10:58
*/
@Service
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

}