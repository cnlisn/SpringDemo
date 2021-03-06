package com.lisn.demo.dao.db1;

import com.lisn.demo.core.universal.Mapper;
import com.lisn.demo.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {
    List<UserInfo> selectAll(@Param("pageNumKey") Integer page,
                              @Param("pageSizeKey") Integer size);
}