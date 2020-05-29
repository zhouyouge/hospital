package com.future.entity;

import java.io.Serializable;

public class Result implements Serializable {
    private Object data;
    private Integer code;
    private Boolean state;


    public void setAll(Object data, Integer code, Boolean state) {
        this.data = data;
        this.code = code;
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
