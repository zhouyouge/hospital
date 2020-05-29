package com.future.service.impl;


import com.future.dao.DepartmentDao;
import com.future.dao.DepartmentsDao;
import com.future.entity.Department;
import com.future.entity.Departments;
import com.future.service.IDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 一级部门服务实现类
 * @Date 16:19 2020/3/26
 * @Param
 * @return
 **/
@Service
public class DepartmentsServiceImpl implements IDepartmentsService {

    @Autowired
    DepartmentsDao departmentsDao; //一级部门

    @Autowired
    DepartmentDao departmentDao;  //科室

    @Override
    public List<Departments> queryDepartments() {
        List<Departments> departmentsList = departmentsDao.queryDepartments();

        List<Departments> departmentsList1 = new ArrayList<>();
        Departments de = null;
        for (Departments departments : departmentsList) {
            de = new Departments();
            List<Department> departments1 = departmentDao.queryDepartment(departments.getId());
            de.setId(departments.getId());
            de.setName(departments.getName());
            de.setDepartment(departments1);
            departmentsList1.add(de);
        }
        return departmentsList1;
    }

    @Override
    public Departments queryCount(Integer id) {
        return departmentsDao.queryCount(id);
    }

    @Override
    public Integer updateDepartmenstNum(Departments departments) {
        return departmentsDao.updateDepartmenstNum(departments);
    }
}
