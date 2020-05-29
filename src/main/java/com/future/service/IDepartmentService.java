package com.future.service;

import com.future.entity.Department;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 二级部门服务层接口
 * @Date 15:57 2020/3/26
 * @Param
 * @return
 **/
public interface IDepartmentService {
    /**
     * 根据ID查询部门信息
     * @return
     */
    List<Department> queryDepartment(Integer departmentsId);
    /**
     * 查询部门INFO
     **/
    Department queryNum(Integer id);
    /**
     * 更新部门数量
     **/
    Integer updateDepartmentNum(Department department);

    /**
     * 查询部门信息
     * @return
     */
    List<Department> queryAllDepartment();
}
