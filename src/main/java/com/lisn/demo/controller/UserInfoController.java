package com.lisn.demo.controller;

import com.lisn.demo.core.aop.AnnotationLog;
import com.lisn.demo.core.ret.RetResult;
import com.lisn.demo.core.ret.RetResponse;
import com.lisn.demo.core.ret.ServiceException;
import com.lisn.demo.model.UserInfo;
import com.lisn.demo.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SG
 * @Description: UserInfoController类
 * Controller中@RestController注解的作用：
 * @RestController是由@Controller和@ResponseBody组成， 表示该类是controller和返回的结果为JSON数据，不是页面路径。
 * @date 2019/12/19 10:45
 */
@RestController
@RequestMapping("/userInfo")
@Api(tags = {"用户操作接口"}, description = "userInfoControler")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/insert")
    public RetResult<Integer> insert(UserInfo userInfo) throws Exception {
        Integer state = userInfoService.insert(userInfo);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = userInfoService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult<Integer> update(UserInfo userInfo) throws Exception {
        Integer state = userInfoService.update(userInfo);
        return RetResponse.makeOKRsp(state);
    }

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectById")
    @AnnotationLog(remark = "查询")
    public RetResult<UserInfo> selectById(@RequestParam String id) throws Exception {
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

    /**
     * //当前页
     * * private int pageNum;
     * * //每页的数量
     * * private int pageSize;
     * * //当前页的数量
     * * private int size;
     * * //当前页面第一个元素在数据库中的行号
     * * private int startRow;
     * * //当前页面最后一个元素在数据库中的行号
     * * private int endRow;
     * * //总记录数
     * * private long total;
     * * //总页数
     * * private int pages;
     * * //结果集
     * * private List<T> list;
     * * //第一页
     * * private int firstPage;
     * * //前一页
     * * private int prePage;
     * * //是否为第一页
     * * private boolean isFirstPage;
     * * //是否为最后一页
     * * private boolean isLastPage;
     * * //是否有前一页
     * * private boolean hasPreviousPage;
     * * //是否有下一页
     * * private boolean hasNextPage;
     * * //导航页码数
     * * private int navigatePages;
     * * //所有导航页号
     * * private int[] navigatepageNums;
     *
     * @param page 页码
     * @param size 每页条数
     * @Description: 分页查询
     * @Reutrn RetResult<PageInfo                               <                               UserInfo>>
     */
    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码",
                    dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数",
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectAll")
    public RetResult<PageInfo<UserInfo>> list(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserInfo> list = userInfoService.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }

    @PostMapping("/login")
    @AnnotationLog(remark = "登录")
    public RetResult<UserInfo> login(String userName, String password) {
        System.out.println("userName=" + userName);
        System.out.println("password=" + password);
        Subject currentUser = SecurityUtils.getSubject();
        //登录
        try {
            currentUser.login(new UsernamePasswordToken(userName, password));
        } catch (IncorrectCredentialsException i) {
            throw new ServiceException("密码输入错误");
        } catch (Exception e) {
            throw new ServiceException("账号密码输入错误");
        }
        //从session取出用户信息
        UserInfo user = (UserInfo) currentUser.getPrincipal();
        return RetResponse.makeOKRsp(user);
    }
}