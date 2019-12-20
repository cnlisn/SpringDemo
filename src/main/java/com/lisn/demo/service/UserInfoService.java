package com.lisn.demo.service;

import com.lisn.demo.model.UserInfo;
import com.lisn.demo.core.universal.Service;

import java.util.List;

/**
* @Description: UserInfoService接口
* @author SG
* @date 2019/12/19 10:43
*/
public interface UserInfoService extends Service<UserInfo> {

    List<UserInfo> selectAlla(Integer page, Integer size);
}