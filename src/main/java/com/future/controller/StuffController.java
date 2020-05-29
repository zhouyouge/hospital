package com.future.controller;


import com.future.entity.Register;
import com.future.entity.ResponseParam;
import com.future.entity.Stuff;
import com.future.service.IStuffService;
import com.future.service.RegisterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author NieJingGuo
 * @Description TODO 工作人员前端控制器
 * @Date 16:25 2020/3/26
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/user")
public class StuffController {


    @Autowired
    IStuffService iStuffService;

    @Autowired
    RegisterService registerService;

    /**
     * 查询人员信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryStuff/{id}", method = RequestMethod.GET)
    public Stuff queryStuff(@PathVariable("id") Integer id) {

        return iStuffService.queryStuff(id);
    }

    /**
     * 根据科室ID查询全部工作人员信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryDoctorStuff/{id}", method = RequestMethod.GET)
    public List<Stuff> queryDoctorStuff(@PathVariable("id") Integer id) {
        return iStuffService.queryDoctorStuff(id);
    }

    /**
     * 全查人员信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllStuff", method = RequestMethod.GET)
    public ResponseParam queryAllStuff(@RequestParam("page") Integer page,
                                       @RequestParam("limit") Integer limit,
                                       String stuffName, HttpSession session) {
        Stuff userInfo = (Stuff) session.getAttribute("userInfo");
        ResponseParam responseParam = new ResponseParam();
        Map<String, Object> map = new HashMap<>();
        map.put("username", userInfo.getUsername());
        map.put("page", (page - 1) * limit);
        map.put("pageSize", limit);
        map.put("name", stuffName);
        responseParam.setData(iStuffService.queryAllStuff(map));
        Integer count = iStuffService.queryCount();
        responseParam.setCode(0);//200
        responseParam.setMsg("成功");
        responseParam.setCount(count);//總數
        return responseParam;
    }

    /**
     * 添加人员信息
     *
     * @param stuff
     * @return
     */
    @RequestMapping(value = "/addStuff", method = RequestMethod.POST)
    public ResponseParam addStuff(@RequestBody Stuff stuff) {
        this.iStuffService.addStuff(stuff);
        ResponseParam rp = new ResponseParam();
        rp.setCode(200);
        rp.setMsg("添加成功");
        return rp;
    }

    /**
     * 删除人员信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteStuffById/{id}", method = RequestMethod.DELETE)
    public ResponseParam deleteStuffById(@PathVariable("id") Integer id) {
        this.iStuffService.deleteStuffById(id);
        ResponseParam rp = new ResponseParam();
        rp.setCode(200);
        rp.setMsg("删除成功");
        return rp;
    }

    /**
     * 删除人员信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteStuffByIds", method = RequestMethod.POST)
    public ResponseParam deleteStuffByIds(@RequestParam String isStr) {
        if (isStr != null && !isStr.equals("")) {
            String[] ids = isStr.split(",");
            for (String id : ids) {
                if (id != null && !id.equals("")) {
                    this.iStuffService.deleteStuffByIds(id);//"2,3,4,5"
                }
            }
        }
        ResponseParam rp = new ResponseParam();
        rp.setCode(200);
        rp.setMsg("删除成功");
        return rp;
    }

    /**
     * 修改人员信息
     *
     * @param stuff
     * @return
     */
    @RequestMapping(value = "/updateStuff", method = RequestMethod.POST)
    public ResponseParam updateStuff(@RequestBody Stuff stuff) {
        ResponseParam rp = new ResponseParam();
        Integer num = this.iStuffService.updateStuff(stuff);
        if (num > 0) {
            rp.setCode(200);
            rp.setMsg("修改成功");
        } else {
            rp.setCode(500);
            rp.setMsg("修改失败");
        }
        return rp;
    }

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseParam loginStuff(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    HttpSession session) {
        ResponseParam rp = iStuffService.loginStuff(username, password);
        if (!StringUtils.isEmpty(rp)) {
            if (rp.getCode() == 200) {
                Stuff stuff = (Stuff) rp.getData();
                if (!StringUtils.isEmpty(stuff)) {
                    session.setAttribute("userInfo", stuff);
                }
            }
        }
        return rp;

    }

    /**
     * 登出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseParam logout(HttpSession session) {
        ResponseParam rp = new ResponseParam();
        Stuff userInfo = (Stuff) session.getAttribute("userInfo");
        if (!StringUtils.isEmpty(userInfo)) {
            session.removeAttribute("userInfo");
        }
        rp.setMsg("退出成功");
        rp.setCode(200);
        return rp;
    }


    @RequestMapping(value = "/yyRegister", method = RequestMethod.POST)
    public ResponseParam yyRegister(@RequestBody Register register) {
        return registerService.yyRegister(register);
    }

    /**
     * 修改密码
     *
     * @param stuff
     * @return
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ResponseParam changePassword(@RequestBody Stuff stuff) {
        return iStuffService.changePassword(stuff);
    }
}
