package com.lisn.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lisn.demo.core.ret.RetResponse;
import com.lisn.demo.core.ret.RetResult;
import com.lisn.demo.core.ret.ServiceException;
import com.lisn.demo.model.UserInfo;
import com.lisn.demo.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller中@RestController注解的作用：
 *
 * @RestController是由@Controller和@ResponseBody组成， 表示该类是controller和返回的结果为JSON数据，不是页面路径。
 */
@RestController
@RequestMapping("userInfo")
@Api(tags = {"用户操作接口"}, description = "userInfoControler")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    //@GetMapping("/hello")
    @PostMapping("/hello")
    public String hello() {
        return "hello SpringBoot";
    }

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectById")
    public RetResult<UserInfo> selectById(@RequestParam String id) {
        UserInfo userInfo = userInfoService.selectById(id);
        System.out.println("selectById==" + id + " userInfo=" + userInfo);
        RetResult<UserInfo> result;
        if (userInfo != null) {
            result = RetResponse.makeOKRsp(userInfo);
        } else {
            //result = RetResponse.makeErrRsp();
            throw new ServiceException("暂无该用户");
        }
        return result;
    }


    @PostMapping("/testException")
    public RetResult<UserInfo> testException(String id) {
        List a = null;
        a.size();
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }

    /**
     * //当前页
     * private int pageNum;
     * //每页的数量
     * private int pageSize;
     * //当前页的数量
     * private int size;
     * //当前页面第一个元素在数据库中的行号
     * private int startRow;
     * //当前页面最后一个元素在数据库中的行号
     * private int endRow;
     * //总记录数
     * private long total;
     * //总页数
     * private int pages;
     * //结果集
     * private List<T> list;
     * //第一页
     * private int firstPage;
     * //前一页
     * private int prePage;
     * //是否为第一页
     * private boolean isFirstPage;
     * //是否为最后一页
     * private boolean isLastPage;
     * //是否有前一页
     * private boolean hasPreviousPage;
     * //是否有下一页
     * private boolean hasNextPage;
     * //导航页码数
     * private int navigatePages;
     * //所有导航页号
     * private int[] navigatepageNums;
     *
     * @param page
     * @param size
     * @return
     */

    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码",
                    dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数",
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectAll")
    public RetResult<PageInfo<UserInfo>> selectAll(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
//        PageInfo<UserInfo> userInfoList = userInfoService.selectAll(page, size);
        List<UserInfo> userInfoList = userInfoService.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return RetResponse.makeOKRsp(pageInfo);
    }

}
