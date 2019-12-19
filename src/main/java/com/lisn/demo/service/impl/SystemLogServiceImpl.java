package com.lisn.demo.service.impl;

import com.lisn.demo.dao.db1.SystemLogMapper;
import com.lisn.demo.model.SystemLog;
import com.lisn.demo.service.SystemLogService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SystemLogService接口实现类
* @author SG
* @date 2019/12/18 11:14
*/
@Service
public class SystemLogServiceImpl extends AbstractService<SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public void insertByBatch(List<SystemLog> systemLogs) {
        systemLogMapper.insertByBatch(systemLogs);
    }
}