package com.future.controller;

import com.alibaba.fastjson.JSON;
import com.future.entity.Register;
import com.future.entity.ResponseParam;
import com.future.entity.Stuff;
import com.future.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/Register")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @RequestMapping(value = "/addRegister", method = RequestMethod.POST)
    public String addRegister(@RequestBody Register register) {
        registerService.addRegister(register);
        return "添加成功";
    }

    @ResponseBody
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    public Object getList(@RequestParam("qdate") String qdate, HttpSession session) {
        Stuff stuff = (Stuff) session.getAttribute("userInfo");
        String str = qdate + String.format("%03d", stuff.getId());
        Register register = new Register();
        register.setToseedoctor(str);
        List<Register> list = registerService.showRegister(register);
        int num = registerService.getRegisterCount(register);
        ResponseParam rp = new ResponseParam();
        rp.setAll(num, 0, list, null);
        return JSON.toJSONString(rp);

    }

}
