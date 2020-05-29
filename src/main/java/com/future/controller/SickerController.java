package com.future.controller;

import com.alibaba.fastjson.JSON;
import com.future.entity.Department;
import com.future.entity.ResponseParam;
import com.future.entity.Sicker;
import com.future.service.SickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sicker")

public class SickerController {
    @Autowired
    SickerService sickerService;

    @RequestMapping(value = "/queryDepartment",method = RequestMethod.GET)
    public List<Department> queryDepartment(){
        List<Department> departments = sickerService.queryDepartment();
        for (Department department : departments) {
            System.err.println("++++++++++++++"+department.getName());
            System.err.println("++++++++++++++"+department.getId());

        }
        return departments;
    }
/*返回数据*/
@ResponseBody
    @RequestMapping(value = "/querySicker",method = RequestMethod.GET)
     public Object querySicker(){
    ResponseParam responseParam = new ResponseParam();
    responseParam.setCode(0);
    List<Sicker> sickers = sickerService.querySicker();
    responseParam.setData(sickers);
     return JSON.toJSONString(responseParam);
    }
    @RequestMapping(value = "/deleteSicker/{sickerId}",method = RequestMethod.POST)
    public String deleteSicker(@PathVariable("sickerId") Integer sickerId){
        sickerService.deleteSicker(sickerId);
    return "删除成功";
    }
    @RequestMapping(value = "/addSicker",method = RequestMethod.POST)
    public String addSicker(Sicker sicker){
        sickerService.addSicker(sicker);
        return "添加成功";
    }
    @RequestMapping(value = "/updateSicker",method = RequestMethod.POST)
    public String updateSicker(@RequestBody Sicker sicker){
        sickerService.updateSicker(sicker);
        return "修改成功";
    }
}
