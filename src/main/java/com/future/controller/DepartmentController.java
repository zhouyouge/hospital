package com.future.controller;

import com.future.entity.Department;
import com.future.entity.Departments;
import com.future.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 二级部门前端控制器
 * @Date 16:25 2020/3/26
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    IDepartmentService iDepartmentService;

    @RequestMapping(value = "/queryDepartment/{departmentsId}",method = RequestMethod.GET)
    public List<Department> queryDepartment(@PathVariable("departmentsId") Integer departmentsId ){
        return iDepartmentService.queryDepartment(departmentsId);
    }

    @RequestMapping(value = "/queryAllDepartment",method = RequestMethod.GET)
    public List<Department> queryAllDepartment(){
        return iDepartmentService.queryAllDepartment();
    }

}
