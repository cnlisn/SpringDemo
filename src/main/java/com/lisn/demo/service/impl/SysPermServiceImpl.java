package com.lisn.demo.service.impl;

import com.lisn.demo.dao.db1.SysPermMapper;
import com.lisn.demo.model.SysPerm;
import com.lisn.demo.service.SysPermService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: SysPermService接口实现类
* @author SG
* @date 2019/12/19 11:09
*/
@Service
public class SysPermServiceImpl extends AbstractService<SysPerm> implements SysPermService {

    @Resource
    private SysPermMapper sysPermMapper;

}