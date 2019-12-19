package com.lisn.demo.service.impl;

import com.lisn.demo.dao.db1.RolePermMapper;
import com.lisn.demo.model.RolePerm;
import com.lisn.demo.service.RolePermService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SG
 * @Description: RolePermService接口实现类
 * @date 2019/12/19 11:09
 */
@Service
public class RolePermServiceImpl extends AbstractService<RolePerm> implements RolePermService {

    @Resource
    private RolePermMapper rolePermMapper;

    @Override
    public List<String> getPermsByUserId(String id) {
        return rolePermMapper.getPermsByUserId(id);
    }
}