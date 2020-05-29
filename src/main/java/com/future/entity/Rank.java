package com.future.entity;

import java.io.Serializable;

/**
 * @ClassName Rank
 * @Description: TODO 职称表
 * @Author NieJingGuo
 * @Date 2020/3/26 15:39
 * @Version V1.0
 **/
public class Rank implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
