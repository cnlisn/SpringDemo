package com.lisn.demo.service.impl;

import com.lisn.demo.dao.db1.SysRoleMapper;
import com.lisn.demo.model.SysRole;
import com.lisn.demo.service.SysRoleService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SysRoleService接口实现类
* @author SG
* @date 2019/12/19 11:06
*/
@Service
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

}