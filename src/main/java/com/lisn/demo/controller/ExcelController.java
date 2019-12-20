package com.lisn.demo.controller;

import com.lisn.demo.core.constant.ExcelConstant;
import com.lisn.demo.core.ret.RetResponse;
import com.lisn.demo.core.ret.RetResult;
import com.lisn.demo.core.utils.ExcelUtils;
import com.lisn.demo.model.ExcelData;
import com.lisn.demo.model.UserInfo;
import com.lisn.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("excel")
@Api(tags = {"Excel表格操作接口"}, description = "userInfoControler")
public class ExcelController {

    @Resource
    private UserInfoService userInfoService;

    @ApiOperation(value = "生成Excel", notes = "查询用户信息生成Excel")
    @PostMapping("/test")
    public RetResult<Integer> test() {
        int rowIndex = 0;
        List<UserInfo> list = userInfoService.selectAlla(0, 0);
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        for (int i = 0, length = list.size(); i < length; i++) {
            UserInfo userInfo = list.get(i);
            List<Object> row = new ArrayList();
            row.add(userInfo.getId());
            row.add(userInfo.getUserName());
            row.add(userInfo.getPassword());
            rows.add(row);
        }
        data.setRows(rows);
        try {
            rowIndex = ExcelUtils.generateExcel(data,
                    ExcelConstant.FILE_PATH + File.separator + ExcelConstant.FILE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RetResponse.makeOKRsp(Integer.valueOf(rowIndex));
    }

    @ApiOperation(value = "导出下载Excel", notes = "查询用户信息 导出下载Excel")
    @GetMapping("/test2")
    public void test2(HttpServletResponse response) {
        int rowIndex = 0;
        List<UserInfo> list = userInfoService.selectAlla(0, 0);
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        for (int i = 0, length = list.size(); i < length; i++) {
            UserInfo userInfo = list.get(i);
            List<Object> row = new ArrayList();
            row.add(userInfo.getId());
            row.add(userInfo.getUserName());
            row.add(userInfo.getPassword());
            rows.add(row);
        }
        data.setRows(rows);
        try {
            ExcelUtils.exportExcel(response, "test2", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}