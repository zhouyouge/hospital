package com.future.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Departments
 * @Description: TODO 一级部门表
 * @Author NieJingGuo
 * @Date 2020/3/26 15:39
 * @Version V1.0
 **/
public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer peoplecount;
    private List<Department> department;


    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

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
}
