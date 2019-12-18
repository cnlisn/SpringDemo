package com.lisn.demo.core.ret;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 返回对象实体
 * 说明：code为状态码、msg为提示信息、data为返回的数据
 */
public class RetResult<T> {

    public int code;

    private String msg;

    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}