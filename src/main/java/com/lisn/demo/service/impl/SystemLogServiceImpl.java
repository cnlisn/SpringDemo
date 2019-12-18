package com.lisn.demo.service.impl;

import com.lisn.demo.dao.SystemLogMapper;
import com.lisn.demo.model.SystemLog;
import com.lisn.demo.service.SystemLogService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: SystemLogService接口实现类
* @author SG
* @date 2019/12/18 11:14
*/
@Service
public class SystemLogServiceImpl extends AbstractService<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

}