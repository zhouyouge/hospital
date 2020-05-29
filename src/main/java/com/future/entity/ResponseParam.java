package com.future.entity;

/**
 * @ClassName ResponseParam
 * @Description: TODO
 * @Author NieJingGuo
 * @Date 2020/4/1 23:35
 * @Version V1.0
 **/
public class ResponseParam {
    private Integer count;
    private Integer code;
    private Object data;
    private String msg;

    public void setAll(Integer count, Integer code, Object data, String msg) {
        this.count = count;
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
