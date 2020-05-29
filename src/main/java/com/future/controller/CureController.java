package com.future.controller;

import com.alibaba.fastjson.JSON;
import com.future.entity.Cure;
import com.future.entity.Result;
import com.future.service.CureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CureController {

    Result result = null;

    @Autowired
    CureService cureService;

    @ResponseBody
    @RequestMapping(value = "cure" , method = RequestMethod.GET)
    public Object ceShi(){
        result = new Result();
        List<Cure> list =  cureService.getList(null);
        result.setAll(list,0,true);
       return JSON.toJSONString(result);
    }

}
