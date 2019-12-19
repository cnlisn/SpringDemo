package com.lisn.demo.service;

import com.lisn.demo.model.RolePerm;
import com.lisn.demo.core.universal.Service;

import java.util.List;

/**
* @Description: RolePermService接口
* @author SG
* @date 2019/12/19 11:09
*/
public interface RolePermService extends Service<RolePerm> {

    List<String> getPermsByUserId(String id);
}