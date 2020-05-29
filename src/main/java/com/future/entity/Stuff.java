package com.future.entity;

import java.io.Serializable;

/**
 * @ClassName Stuff
 * @Description: TODO 工作人员表
 * @Author NieJingGuo
 * @Date 2020/3/26 15:38
 * @Version V1.0
 **/
public class Stuff extends Page implements Serializable {
    private Integer id;//编号
    private String name;//姓名
    private Integer age;//年龄
    private String sex;//性别 1男  0女
    private String hiredate;//受雇时间
    private Integer departmentid;//二级部门ID(科室)
    private Integer rankid;//职称ID
    private String username;//账号
    private String password;//密码
    private String leavedate;//离职日期
    private String status;//状态  0在职 1待职 2离职

    private String departmentName;//科室名称
    private String rankName;//职位名称

    private String departmentsName;//一级部门名称
    private Integer departmentsId;//一级部门ID

    private String newPassword; //新密码

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getDepartmentsName() {
        return departmentsName;
    }

    public void setDepartmentsName(String departmentsName) {
        this.departmentsName = departmentsName;
    }

    public Integer getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(Integer departmentsId) {
        this.departmentsId = departmentsId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getRankid() {
        return rankid;
    }

    public void setRankid(Integer rankid) {
        this.rankid = rankid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }
}
