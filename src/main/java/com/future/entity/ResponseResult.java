package com.future.entity;


import java.io.Serializable;

/**
 *封装响应结果集实体类
 *
 */
public class ResponseResult implements Serializable {

    private boolean result=false;
    private Integer flag;
    private Object data;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
