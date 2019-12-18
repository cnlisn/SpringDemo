package com.lisn.demo.controller;

import com.lisn.demo.core.ret.RetResult;
import com.lisn.demo.core.ret.RetResponse;
import com.lisn.demo.model.Websites;
import com.lisn.demo.service.WebsitesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: WebsitesController类
* @author SG
* @date 2019/12/18 14:42
*/
@RestController
@RequestMapping("/websites")
public class WebsitesController {

    @Resource
    private WebsitesService websitesService;

    @PostMapping("/insert")
    public RetResult<Integer> insert(Websites websites) throws Exception{
        Integer state = websitesService.insert(websites);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = websitesService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult<Integer> update(Websites websites) throws Exception {
        Integer state = websitesService.update(websites);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public RetResult<Websites> selectById(@RequestParam String id) throws Exception {
        Websites websites = websitesService.selectById(id);
        return RetResponse.makeOKRsp(websites);
    }

    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn RetResult<PageInfo<Websites>>
    */
    @PostMapping("/list")
    public RetResult<PageInfo<Websites>> list(@RequestParam(defaultValue = "0") Integer page,
    @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<Websites> list = websitesService.selectAll();
        PageInfo<Websites> pageInfo = new PageInfo<Websites>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}