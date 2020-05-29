package com.future.entity;

import java.io.Serializable;

public class Register implements Serializable {
    private Integer id;
    private String cardid;//卡号
    private Integer doctorid;//医生id
    private String toseedoctor;
    private String departmentName;
    private Sicker sicker;
    private Stuff stuff;
    private String toseedoctorStart;

    private String registerData;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRegisterData() {
        return registerData;
    }

    public void setRegisterData(String registerData) {
        this.registerData = registerData;
    }

    public Register() {
    }

    public String getToseedoctorStart() {
        return toseedoctorStart;
    }

    public void setToseedoctorStart(String toseedoctorStart) {
        this.toseedoctorStart = toseedoctorStart;
    }

    public Sicker getSicker() {
        return sicker;
    }

    public void setSicker(Sicker sicker) {
        this.sicker = sicker;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getToseedoctor() {
        return toseedoctor;
    }

    public void setToseedoctor(String toseedoctor) {
        this.toseedoctor = toseedoctor;
    }
}
