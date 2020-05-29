package com.future.controller;

import com.future.entity.Sicker;
import com.future.entity.Sickertrans;
import com.future.service.SickertransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/sickertrans")
public class SickertransController {
   @Autowired
    SickertransService sickertransService;
@RequestMapping(value = "/querySickertrans",method = RequestMethod.GET)
   public List<Sickertrans> querySickertrans(){
       List<Sickertrans> sickertrans = sickertransService.querySickertrans();
       for (Sickertrans sickertrans1 :sickertrans) {
           System.out.println("++++++"+sickertrans1.getCardid());
       }
       return sickertrans;
   }
    @RequestMapping(value = "/addSickertrans",method = RequestMethod.POST)
    public String addSickertrans(@RequestBody Sickertrans sickertrans){
        sickertransService.addSickertrans(sickertrans);
        return "添加成功";
    }
    @RequestMapping(value = "/deleteSickertrans/{sickertransId}",method = RequestMethod.POST)
    public String deleteSickertrans(@PathVariable("sickertransId") Integer sickertransId){
        sickertransService.deleteSickertrans(sickertransId);
        return "删除成功";
    }
    @RequestMapping(value = "/updateSickertrans",method = RequestMethod.POST)
    public String updateSickertrans(@RequestBody Sickertrans sickertrans) {
        sickertransService.updateSickertrans(sickertrans);
        return "修改成功";
    }
}
