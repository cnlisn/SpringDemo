package com.lisn.demo.dao.db1;

import com.lisn.demo.core.universal.Mapper;
import com.lisn.demo.model.RolePerm;

import java.util.List;

public interface RolePermMapper extends Mapper<RolePerm> {
    List<String> getPermsByUserId(String userId);
}