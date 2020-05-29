package com.future.service;

import com.future.entity.Sickertrans;

import java.util.List;

public interface SickertransService {
    public List<Sickertrans> querySickertrans();//查询患者
    public Integer deleteSickertrans(Integer sickertransId);//删除患者
    public Integer addSickertrans(Sickertrans sickertrans);//添加
    public Integer updateSickertrans(Sickertrans sickertrans);//修改
}
