package com.future.entity;

import java.io.Serializable;

public class Cure implements Serializable {
    private Integer id;
    private Integer choose;
    private String drugName;
    private Integer useageid;
    private Integer dosageid;
    private Double bill;
    private Integer pid;
    private String useageName;
    private String dosageName;
    private String remark;
    private Integer unitid;
    private String unitName;


    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUseageName() {
        return useageName;
    }

    public void setUseageName(String useageName) {
        this.useageName = useageName;
    }

    public String getDosageName() {
        return dosageName;
    }

    public void setDosageName(String dosageName) {
        this.dosageName = dosageName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChoose() {
        return choose;
    }

    public void setChoose(Integer choose) {
        this.choose = choose;
    }

    public Integer getUseageid() {
        return useageid;
    }

    public void setUseageid(Integer useageid) {
        this.useageid = useageid;
    }

    public Integer getDosageid() {
        return dosageid;
    }

    public void setDosageid(Integer dosageid) {
        this.dosageid = dosageid;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
