package com.future.controller;


import com.future.entity.Departments;
import com.future.service.IDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 一级部门前端控制器
 * @Date 16:25 2020/3/26
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    IDepartmentsService departmentsService;

    @RequestMapping(value = "/queryDepartments",method = RequestMethod.GET)
    public List<Departments> queryDepartments(){
        return departmentsService.queryDepartments();
    }
}
