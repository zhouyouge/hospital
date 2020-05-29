package com.future.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.future.entity.*;
import com.future.service.CureService;
import com.future.service.DrugService;
import com.future.service.IllnessService;
import com.future.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("pre")
public class PrescriptionController {

    @Autowired
    IllnessService illnessService;
    @Autowired
    PrescriptionService prescriptionService;
    @Autowired
    DrugService drugService;
    @Autowired
    CureService cureService;




    @ResponseBody
    @RequestMapping(value = "showMySickerCured")
    public Object showMySickerCured(Prescription prescription,HttpSession session){
        ResponseParam rp = new ResponseParam();
        Stuff stuff = (Stuff) session.getAttribute("userInfo");
        prescription.setStaffid(stuff.getId());
        List<Prescription> list = prescriptionService.getList(prescription);
        int num = prescriptionService.getCount(prescription);
        if (StringUtils.isEmpty(list)){
            return null;
        }
        rp.setAll(num,0,list,null);

        return JSON.toJSONString(rp,SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "curePage")
    public String curePage(Model model){
        return "/static/jsp/cure/addPrescription.jsp";
    }


    @ResponseBody
    @RequestMapping(value = "cureInti",method = RequestMethod.GET)
    public Object cureInti(){
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();
        List<IllnessType> list =  illnessService.getIllnessTypeList(new IllnessType());
        map.put("illnessTypeList",list);
        List<Prescription> list1 = prescriptionService.getCureType();
        map.put("cureTypeList",list1);
        List<Cure> list2 = prescriptionService.getUseage();
        map.put("useageList",list2);

        List<Drug> list3 = drugService.getDrList(new Drug());
        map.put("drugList",list3);
        result.setAll(map,0,true);
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping(value = "addPrescript",method = RequestMethod.GET)
    public Object addPrescript( Prescription prescription, HttpSession session){
        Result result = new Result();
        if (StringUtils.isEmpty(prescription)){
            return null;
        }
        if (StringUtils.isEmpty(prescription.getCureList())){
            return null;
        }
       Stuff stuff = (Stuff) session.getAttribute("userInfo");
        prescription.setStaffid(stuff.getId());

        int flag = prescriptionService.addPrescription(prescription);
        for (Cure c:
                prescription.getCureList()) {
            c.setPid(prescription.getId());
        }
        int flag1 = cureService.addCure(prescription.getCureList());
        if (flag>0&&flag1>0){
            result.setAll(null,200,true);
        }else{
            result.setAll(null,400,false);
        }
        return JSON.toJSONString(result);
    }



    @ResponseBody
    @RequestMapping(value = "getIllness",method = RequestMethod.GET)
    public Object getIllness(@RequestParam("id") Integer id){
        Result result = new Result();
        Illness illness = new Illness();
        illness.setTypeid(id);
        List<Illness> list =  illnessService.getIllnessByTypeId(illness);
        result.setAll(list,0,true);
        return JSON.toJSONString(result);
    }


}
