package com.future.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Prescription implements Serializable  {
    private Integer id;
    private Integer typeid;
    private String mainsuit;
    private String typename;
    private Integer staffid;
    private Stuff stuff;
    private Integer sickerid;
    private Sicker sicker;
    private Date curedate;
    private Integer state;
    private Integer illnessid;
    private String illnessName;
    private List<Cure> cureList;
    private String startTime;
    private String endTime;

    private Integer page;
    private Integer limit;
    private Integer startNum;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (this.limit!=null){
            this.startNum = this.limit*(page-1);
        }
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (this.page!=null){
            this.startNum = (this.page-1)*limit;
        }
        this.limit = limit;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getMainsuit() {
        return mainsuit;
    }

    public void setMainsuit(String mainsuit) {
        this.mainsuit = mainsuit;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Integer getSickerid() {
        return sickerid;
    }

    public void setSickerid(Integer sickerid) {
        this.sickerid = sickerid;
    }

    public Sicker getSicker() {
        return sicker;
    }

    public void setSicker(Sicker sicker) {
        this.sicker = sicker;
    }

    public Date getCuredate() {
        return curedate;
    }

    public void setCuredate(Date curedate) {
        this.curedate = curedate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIllnessid() {
        return illnessid;
    }

    public void setIllnessid(Integer illnessid) {
        this.illnessid = illnessid;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public List<Cure> getCureList() {
        return cureList;
    }

    public void setCureList(List<Cure> cureList) {
        this.cureList = cureList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}
