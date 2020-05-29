package com.future.dao;

import com.future.entity.Department;
import com.future.entity.Departments;

import java.util.List;

/**
 * @ClassName DepartmentsDao
 * @Description: TODO 一级部门DAO接口
 * @Author NieJingGuo
 * @Date 2020/3/26 15:51
 * @Version V1.0
 **/
public interface DepartmentsDao {
    /**
     * 查询一级部门信息
     * @return
     */
    List<Departments> queryDepartments();

    /**
     * 查询一级部门数量
     **/
    Departments queryCount(Integer id);

    /**
     * 更新一级部门数量
     **/
    Integer updateDepartmenstNum(Departments departments);
}
