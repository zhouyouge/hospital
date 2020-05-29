package com.future.service.impl;

import com.future.dao.DepartmentDao;
import com.future.dao.DepartmentsDao;
import com.future.dao.StuffDao;
import com.future.entity.Department;
import com.future.entity.Departments;
import com.future.entity.ResponseParam;
import com.future.entity.Stuff;
import com.future.service.IStuffService;
import com.future.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author NieJingGuo
 * @Description TODO 工作人员服务实现类
 * @Date 16:19 2020/3/26
 * @Param
 * @return
 **/
@Service
public class StuffServiceImpl implements IStuffService {

    private final static Logger log = LoggerFactory.getLogger(StuffServiceImpl.class);

    @Autowired
    StuffDao stuffDao;

    @Autowired
    DepartmentsDao departmentsDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 根据ID查询工作人员信息
     *
     * @param id
     * @return
     */
    @Override
    public Stuff queryStuff(Integer id) {
        return stuffDao.queryStuff(id);
    }

    /**
     * 人员信息的添加
     *
     * @param stuff
     * @return
     */
    @Transactional
    @Override
    public Integer addStuff(Stuff stuff) {
        stuff.setStatus("0");
        String password1 = MD5Utils.getPassword(stuff.getPassword());
        stuff.setPassword(password1);
        Integer num = stuffDao.addStuff(stuff);
        if (num > 0) {
            log.info("=========人员添加成功！===========");

            //二级部门id是添加的
            Integer departmentid = stuff.getDepartmentid();

            Integer type = 1;

            this.getDepartmentInfo(departmentid, type);

        } else {
            log.info("=========人员添加失败！===========");
        }
        return num;
    }

    /**
     * 对人员的删除
     *
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Integer deleteStuffById(Integer id) {
        Stuff stuff = stuffDao.queryStuff(id);
        //二级部门id2
        Integer departmentid = stuff.getDepartmentid();

        Integer type = 2;

        this.getDepartmentInfo(departmentid, type);

        Integer num = stuffDao.deleteStuffById(id);

        if (num == 1) {
            System.err.println("人员信息删除成功！");
        } else {
            System.err.println("人员信息删除失败！");
        }

        return num;
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public Integer deleteStuffByIds(String ids) {
        Integer num = stuffDao.deleteStuffByIds(ids);
        if (num == 1) {

            System.err.println("人员信息删除成功！");
        } else {
            System.err.println("人员信息删除失败！");
        }

        return num;
    }

    /**
     * 查询一二级部门人员的信息
     *
     * @param departmentid
     * @param type
     */
    public void getDepartmentInfo(Integer departmentid, Integer type) {
        //查询二级部门信息（二级部门id2作为条件）
        Department department = departmentDao.queryNum(departmentid);
        //查询一级部门的信息（一级部门id1作为条件）
        Departments departments = departmentsDao.queryCount(department.getDepartmentsid());

        this.updataNumInfo(departments, department, type);

    }

    /**
     * 对人员的数量更新
     *
     * @param departments
     * @param department
     * @param type
     */
    public void updataNumInfo(Departments departments, Department department, Integer type) {
        //调用一级部门人数更新方法
        this.departmentsInfo(departments, type);
        //调用二级部门人数更新方法
        this.departmentInfo(department, type);

    }

    //一级部门
    public void departmentsInfo(Departments departments, Integer type) {
        Departments dem = new Departments();
        dem.setId(departments.getId());
        if (type == 1) { // 1 》添加人员
            dem.setPeoplecount(departments.getPeoplecount() + 1);
        } else if (type == 2) { //  2 》删除人员
            dem.setPeoplecount(departments.getPeoplecount() - 1);
        }
        //更新一级部门人数
        Integer num1 = departmentsDao.updateDepartmenstNum(dem);
        if (num1 == 1) {
            log.info("=========一级部门人数更新成功！===========");
        } else {
            log.info("=========一级部门人数更新失败！===========");
        }
    }

    //二级部门
    public void departmentInfo(Department department, Integer type) {
        //二级部门人数更新
        Department dm = new Department();
        dm.setId(department.getId());
        if (type == 1) { // 1 》添加人员
            //二级部门人数新增+1
            dm.setPeoplecount(department.getPeoplecount() + 1);
        } else if (type == 2) { //  2 》删除人员
            //二级部门人数 -1
            dm.setPeoplecount(department.getPeoplecount() - 1);
        }
        Integer num2 = departmentDao.updateDepartmentNum(dm);
        if (num2 == 1) {
            log.info("=========二级部门人数更新成功！===========");
        } else {
            log.info("=========二级部门人数更新失败！===========");
        }
    }

    /**
     * 条件查询
     *
     * @param map
     * @return
     */
    @Override
    public List<Stuff> queryAllStuff(Map<String, Object> map) {
        List<Stuff> qStuff = stuffDao.queryAllStuff(map);
        return qStuff;
    }

    @Override
    public List<Stuff> getQueryRankStuff(String rankName) {
        return null;
    }

    /**
     * 修改人员信息
     *
     * @param stuff
     * @return
     */
    @Override
    public Integer updateStuff(Stuff stuff) {
        Integer departmentid = stuff.getDepartmentid();
        Integer status = Integer.valueOf(stuff.getStatus());
        if (status == 2) { //离职人员部门人数减1
            Integer type = 2;
            this.getDepartmentInfo(departmentid, type);
            //创建当前时间
            Date d = new Date(); // 注意是util包下的Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(d);
            stuff.setLeavedate(date);
            return stuffDao.updateStuff(stuff);

        } else {

            return stuffDao.updateStuff(stuff);
        }

    }

    @Override
    public ResponseParam loginStuff(String userName, String password) {
        ResponseParam rp = new ResponseParam();
        if (StringUtils.isEmpty(userName)) {
            rp.setCode(501);
            rp.setMsg("用户名为空！");
            return rp;
        } else if (StringUtils.isEmpty(password)) {
            rp.setCode(502);
            rp.setMsg("密码为空");
            return rp;
        }
        String password1 = MD5Utils.getPassword(password);
        Stuff stuff = stuffDao.loginStuff(userName, password1);
        if (StringUtils.isEmpty(stuff)) {
            rp.setCode(503);
            rp.setMsg("用户名或密码输入错误");
            return rp;
        } else {
            rp.setData(stuff);
            rp.setCode(200);
            rp.setMsg("登陆成功！");
            return rp;
        }
    }

    @Override
    public Integer queryCount() {
        return stuffDao.queryCount();
    }

    @Override
    public List<Stuff> queryDoctorStuff(Integer id) {
        return stuffDao.queryDoctorStuff(id);
    }

    /**
     * 修改密码
     *
     * @param stuff
     * @return
     */
    @Override
    public ResponseParam changePassword(Stuff stuff) {
        ResponseParam responseParam = new ResponseParam();
        Stuff stuff1 = stuffDao.queryStuff(stuff.getId());
        String password = stuff1.getPassword();//数据库密码
        String password1 = stuff.getPassword();//输入的密码
        String password2 = MD5Utils.getPassword(password1);//加密输入的密码
        if (password.equals(password2)) {
            String pwd = MD5Utils.getPassword(stuff.getNewPassword());
            stuff.setPassword(pwd);
            Integer rp = stuffDao.changePassword(stuff);
            responseParam.setData(rp);
            responseParam.setMsg("密码修改成功");
            responseParam.setCode(200);
        } else {
            responseParam.setMsg("旧密码输入错误！");
            responseParam.setCode(500);
        }
        return responseParam;
    }

}
