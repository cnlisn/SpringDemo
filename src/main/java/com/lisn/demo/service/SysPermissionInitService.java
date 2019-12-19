package com.lisn.demo.service;

import com.lisn.demo.model.SysPermissionInit;
import com.lisn.demo.core.universal.Service;

import java.util.List;

/**
* @Description: SysPermissionInitService接口
* @author SG
* @date 2019/12/19 16:55
*/
public interface SysPermissionInitService extends Service<SysPermissionInit> {
    List<SysPermissionInit> selectAllOrderBySort();
}