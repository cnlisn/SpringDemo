package com.lisn.demo.dao.db1;

import com.lisn.demo.core.universal.Mapper;
import com.lisn.demo.model.UserRole;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {
    //根据用户id查询该用户所有角色
    List<String> getRolesByUserId(String userId);
}