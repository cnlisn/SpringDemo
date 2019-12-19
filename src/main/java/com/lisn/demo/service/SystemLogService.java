package com.lisn.demo.service;

import com.lisn.demo.model.SystemLog;
import com.lisn.demo.core.universal.Service;

import java.util.List;

/**
* @Description: SystemLogService接口
* @author SG
* @date 2019/12/18 11:14
*/
public interface SystemLogService extends Service<SystemLog> {

    void insertByBatch(List<SystemLog> systemLogs);
}