package com.future.service.impl;

import com.future.dao.DepartmentDao;
import com.future.entity.Department;
import com.future.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 二级部门服务实现类
 * @Date 16:19 2020/3/26
 * @Param
 * @return
 **/
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Department> queryDepartment(Integer departmentsId) {
        return departmentDao.queryDepartment(departmentsId);
    }

    @Override
    public Department queryNum(Integer id) {
        return departmentDao.queryNum(id);
    }

    @Override
    public Integer updateDepartmentNum(Department department) {
        Integer num = departmentDao.updateDepartmentNum(department);
        return num;
    }

    @Override
    public List<Department> queryAllDepartment() {
        return departmentDao.queryAllDepartment();
    }

}
