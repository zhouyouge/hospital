package com.future.dao;

import com.future.entity.Sickertrans;

import java.util.List;

public interface SickertransDao {
    public List<Sickertrans> querySickertrans();//查询患者
    public Integer deleteSickertrans(Integer sickertransId);//删除患者
    public Integer addSickertrans(Sickertrans sickertrans);//添加
    public Integer updateSickertrans(Sickertrans sickertrans);//修改

}
