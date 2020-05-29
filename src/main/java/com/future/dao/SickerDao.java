package com.future.dao;

import com.future.entity.Department;
import com.future.entity.Sicker;

import java.util.List;

public interface SickerDao {

        public List<Department> queryDepartment();//查询科室信息
        public List<Sicker> querySicker();//查询患者信息
        public Integer deleteSicker(Integer sickerId);//删除患者信息
        public Integer addSicker(Sicker sicker);//添加患者信息
        public Integer updateSicker(Sicker sicker);//修改患者信息

}
