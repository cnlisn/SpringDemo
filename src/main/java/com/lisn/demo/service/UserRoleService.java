package com.lisn.demo.service;

import com.lisn.demo.model.UserRole;
import com.lisn.demo.core.universal.Service;

import java.util.List;

/**
* @Description: UserRoleService接口
* @author SG
* @date 2019/12/19 10:58
*/
public interface UserRoleService extends Service<UserRole> {

    List<String> getRolesByUserId(String id);
}