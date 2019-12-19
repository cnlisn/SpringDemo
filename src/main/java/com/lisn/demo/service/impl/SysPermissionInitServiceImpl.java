package com.lisn.demo.service.impl;

import com.lisn.demo.dao.db1.SysPermissionInitMapper;
import com.lisn.demo.model.SysPermissionInit;
import com.lisn.demo.service.SysPermissionInitService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SG
 * @Description: SysPermissionInitService接口实现类
 * @date 2019/12/19 16:55
 */
@Service
public class SysPermissionInitServiceImpl extends AbstractService<SysPermissionInit> implements SysPermissionInitService {

    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

    @Override
    public List<SysPermissionInit> selectAllOrderBySort() {
        return sysPermissionInitMapper.selectAllOrderBySort();
    }
}