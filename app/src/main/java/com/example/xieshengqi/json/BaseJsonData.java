package com.example.xieshengqi.json;

/**
 * Created by xieshengqi on 15/11/12.
 */
public class BaseJsonData<T> {

    private String msg;
    private T data;
    private  String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
