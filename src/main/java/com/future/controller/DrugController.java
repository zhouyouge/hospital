package com.future.controller;

import com.alibaba.fastjson.JSON;
import com.future.entity.Drug;
import com.future.entity.ResponseParam;
import com.future.entity.ResponseResult;
import com.future.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/DRUG")
public class DrugController {

    @Autowired
    private DrugService drugService;

    /**
     * 查询集合
     * @param drug
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object getDrList(Drug drug) {
        ResponseParam rp = new ResponseParam();
//        set状态码，必须是200
        rp.setCode(0);
//        查到list的集合塞进去
        rp.setData(drugService.getDrList(drug));
        return JSON.toJSONString(rp);
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Object getAddDrug(Drug drug, HttpSession session) {
        ResponseResult rs = new ResponseResult();

        if (!StringUtils.isEmpty(drug)) {
            boolean flag = drugService.addDrug(drug);
            if (flag){
                rs.setFlag(1);
                rs.setData("添加完成！");
                rs.setResult(true);
            }else{
                rs.setFlag(2);
                rs.setData("添加失败！");
                rs.setResult(false);
            }
        }
        return JSON.toJSONString(rs);
    }


    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public Object getDelDrug(Drug drug,HttpSession session){
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(drug)){
            boolean flag = drugService.delDrug(drug);
            if (flag){
                rs.setFlag(3);
                rs.setData("删除成功！");
                rs.setResult(true);
            }else {
                rs.setFlag(4);
                rs.setData("删除失败！");
                rs.setResult(false);
            }
        }
        return JSON.toJSONString(rs);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public Object getUpdateDrug(Drug drug,HttpSession session){
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(drug)){
            boolean flag = drugService.updateDrug(drug);
            if (flag){
                rs.setFlag(3);
                rs.setData("修改成功！");
                rs.setResult(true);
            }else {
                rs.setFlag(4);
                rs.setData("修改失败！");
                rs.setResult(false);
            }
        }
        return JSON.toJSONString(rs);
    }
}
