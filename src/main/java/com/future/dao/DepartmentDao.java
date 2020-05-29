package com.future.dao;

import com.future.entity.Department;
import com.future.entity.Departments;

import java.util.List;

/**
 * @ClassName DepartmentDao
 * @Description: TODO 二级部门DAO接口
 * @Author NieJingGuo
 * @Date 2020/3/26 15:52
 * @Version V1.0
 **/
public interface DepartmentDao {
    /**
     * 查询二级部门信息
     * @return
     */
    List<Department> queryDepartment(Integer departmentsId);
    /**
     * 查询部门数量
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
