package com.lisn.demo.dao.db1;

import com.lisn.demo.core.universal.Mapper;
import com.lisn.demo.model.SysPermissionInit;

import java.util.List;

public interface SysPermissionInitMapper extends Mapper<SysPermissionInit> {
    List<SysPermissionInit> selectAllOrderBySort();
}