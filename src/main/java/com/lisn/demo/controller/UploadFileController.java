package com.lisn.demo.controller;

import com.lisn.demo.core.ret.RetResponse;
import com.lisn.demo.core.ret.RetResult;
import com.lisn.demo.core.utils.UploadActionUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 文件上传接口
 *
 * 输入localhost:8080/uploadFile/upload
 * 注意：请求参数如下
 * key取名file
 * 多文件写成file[0],file[1],file[2]
 */
@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {

    @PostMapping("/upload")
    public RetResult<List<String>> upload(HttpServletRequest httpServletRequest) throws Exception {
        List<String> list = UploadActionUtil.uploadFile(httpServletRequest);
        return RetResponse.makeOKRsp(list);
    }
}