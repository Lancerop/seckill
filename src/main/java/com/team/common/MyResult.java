package com.team.common;

import com.team.common.exception.MyException;

import java.io.Serializable;

/**
 * @Classname MyResult
 * @Description TODO
 * @Date 2021/7/17 上午10:14
 * @Created by muyi
 */
public class MyResult<T> implements Serializable {
    private static final long serialVersionUID = 2994494589314183496L;

    private boolean success;
    private T data;
    private BaseQuery query;
    private String errCode;
    private String errMsg;

    public MyResult() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseQuery getQuery() {
        return this.query;
    }

    public void setQuery(BaseQuery query) {
        this.query = query;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static <T> MyResult ok(T data, BaseQuery query) {
        MyResult<T> result = new MyResult();
        result.setData(data);
        result.setQuery(query);
        result.setSuccess(true);
        return result;
    }

    public static <T> MyResult<T> ok() {
        return ok(null);
    }

    public static <T> MyResult<T> ok(T data) {
        return ok(data, (BaseQuery)null);
    }

    public static <T> MyResult<T> fail(String errCode, String errMsg) {
        MyResult result = new MyResult();
        result.setSuccess(false);
        result.setErrCode(errCode);
        result.setErrMsg(errMsg);
        return result;
    }

    public static <T> MyResult<T> fail(MyException e) {
        return fail(e.getErrorCode(), e.getErrorMsg());
    }
}
