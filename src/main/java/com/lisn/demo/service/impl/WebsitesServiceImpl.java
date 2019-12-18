package com.lisn.demo.service.impl;

import com.lisn.demo.dao.db2.WebsitesMapper;
import com.lisn.demo.model.Websites;
import com.lisn.demo.service.WebsitesService;
import com.lisn.demo.core.universal.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: WebsitesService接口实现类
* @author SG
* @date 2019/12/18 14:42
*/
@Service
public class WebsitesServiceImpl extends AbstractService<Websites> implements WebsitesService {

    @Resource
    private WebsitesMapper websitesMapper;

}