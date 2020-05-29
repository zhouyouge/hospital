package com.future.controller;

import com.alibaba.fastjson.JSON;
import com.future.entity.Drugtrans;
import com.future.entity.ResponseParam;
import com.future.entity.ResponseResult;
import com.future.service.DrugtransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/DRUGTRANS")
public class DrugtransController {


    @Autowired
    private DrugtransService drugtransService;

    /**
     * 查询交易记录集合
     * @param drugtrans
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object getDrugtransList(Drugtrans drugtrans){
        ResponseParam rp = new ResponseParam();
        rp.setCode(0);
        rp.setData(drugtransService.getDrugtransList(drugtrans));
        return JSON.toJSONString(rp);
    }

    @ResponseBody
    @RequestMapping(value = "/addDrugtrans",method = RequestMethod.GET)
    public Object getAddDrugtrans(Drugtrans drugtrans, HttpSession session) {
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(drugtrans)) {
            boolean flag = drugtransService.addDrugtrans(drugtrans);
            if (flag){
                rs.setFlag(1);
                rs.setData("添加成功！");
                rs.setResult(true);
            }else {
                rs.setFlag(2);
                rs.setData("添加失败！");
                rs.setResult(false);
            }
        }
        return JSON.toJSONString(rs);
    }

    @ResponseBody
    @RequestMapping(value = "/delDrugtrans",method = RequestMethod.GET)
    public Object getDelDrugTrans(Drugtrans drugtrans, HttpSession session) {
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(drugtrans)) {
            boolean flag = drugtransService.delDrugtrans(drugtrans);
            if (flag){
                rs.setFlag(1);
                rs.setData("删除成功！");
                rs.setResult(true);
            }else {
                rs.setFlag(2);
                rs.setData("删除失败！");
                rs.setResult(false);
            }
        }
        return JSON.toJSONString(rs);
    }

    @ResponseBody
    @RequestMapping(value = "/updateDrugtrans",method = RequestMethod.GET)
    public Object getUpdateDruntrans(Drugtrans drugtrans, HttpSession session) {
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(drugtrans)) {
            boolean flag = drugtransService.updateDrugtrans(drugtrans);
            if (flag){
                rs.setFlag(1);
                rs.setData("更新成功！");
                rs.setResult(true);
            }else {
                rs.setFlag(2);
                rs.setData("更新失败！");
                rs.setResult(false);
            }
        }
        return JSON.toJSONString(rs);
    }
}
