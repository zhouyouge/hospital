package com.future.controller;

import com.alibaba.fastjson.JSON;
import com.future.entity.Result;
import com.future.entity.Unit;
import com.future.service.UnitService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "unit")
public class UnitController  {

    @Autowired
    UnitService unitService;

    @ResponseBody
    @RequestMapping(value = "getUnitById",method = RequestMethod.GET)
    public Object getUnitById(@RequestParam("id")Integer id){
        Unit unit = new Unit();
        unit.setId(id);
        List<Unit> list = unitService.getUnitList(unit);
        Result result = new Result();
        result.setAll(list.get(0),0,true);
        return JSON.toJSONString(result);
    }

}
