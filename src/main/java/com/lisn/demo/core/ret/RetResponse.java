package com.lisn.demo.core.ret;

/**
 * 将结果转换为封装后的对象
 */
public class RetResponse {

    private final static String SUCCESS = "success";
    private final static String Err = "err";

    public static <T> RetResult<T> makeOKRsp() {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> RetResult<T> makeOKRsp(T data) {
        return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RetResult<T> makeErrRsp() {
        return new RetResult<T>().setCode(RetCode.FAIL).setMsg(Err);
    }

    public static <T> RetResult<T> makeErrRsp(T data) {
        return new RetResult<T>().setCode(RetCode.FAIL).setMsg(Err).setData(data);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RetResult<T> makeRsp(int code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}