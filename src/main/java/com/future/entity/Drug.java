package com.future.entity;

import java.io.Serializable;
import java.sql.Date;

public class Drug implements Serializable {

    private int id;
    private String name;
    private String form;
    private int formid;
    private Integer unitid;
    private int batch;
    private int supplierid;
    private double bprice;
    private double sprice;
    private double guaranteeperiod;
    private Date expirationdate;
    private double totalprice;


    public int getFormid() {
        return formid;
    }

    public void setFormid(int formid) {
        this.formid = formid;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplier(int supplierid) {
        this.supplierid = supplierid;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public double getSprice() {
        return sprice;
    }

    public void setSprice(double sprice) {
        this.sprice = sprice;
    }

    public double getGuaranteeperiod() {
        return guaranteeperiod;
    }

    public void setGuaranteeperiod(double guaranteeperiod) {
        this.guaranteeperiod = guaranteeperiod;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }
}
