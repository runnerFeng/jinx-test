package com.common.test.demo12_responseJsonResult;

/**
 * Desc:
 * Created by jinx on 2017/6/14.
 */
public class ResultWrapper<T> {

    private static final int CODE_OK = 200;
    private static final String MSG_OK = "OK";

    private Integer code;
    private String msg;
    private T data;

    public ResultWrapper(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultWrapper(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultWrapper buildSuccess() {
        return new ResultWrapper(CODE_OK, MSG_OK);
    }

    public static <T> ResultWrapper<T> buildSuccess(T data) {
        return new ResultWrapper(CODE_OK, MSG_OK, data);
    }

    public static ResultWrapper buildError(Integer code) {
        return new ResultWrapper(code, null);
    }

    public static ResultWrapper buildError(Integer code, String msg) {
        return new ResultWrapper(code, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
