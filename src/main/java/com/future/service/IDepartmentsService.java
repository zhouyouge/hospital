package com.future.service;


import com.future.entity.Departments;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 一级部门服务层接口
 * @Date 15:58 2020/3/26
 * @Param
 * @return
 **/
public interface IDepartmentsService {
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
