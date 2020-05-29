package com.future.entity;

import java.io.Serializable;

/**
 * @ClassName Department
 * @Description: TODO 二级部门表
 * @Author NieJingGuo
 * @Date 2020/3/26 15:41
 * @Version V1.0
 **/
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer peoplecount;

    private Integer departmentsid; //一级部门ID

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

    public Integer getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Integer peoplecount) {
        this.peoplecount = peoplecount;
    }

    public Integer getDepartmentsid() {
        return departmentsid;
    }

    public void setDepartmentsid(Integer departmentsid) {
        this.departmentsid = departmentsid;
    }
}
