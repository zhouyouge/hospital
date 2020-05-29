package com.future.service;

import com.future.entity.ResponseParam;
import com.future.entity.Stuff;

import java.util.List;
import java.util.Map;

/**
 * @Author NieJingGuo
 * @Description TODO 工作人员服务层接口
 * @Date 15:56 2020/3/26
 * @Param
 * @return
 **/
public interface IStuffService {
    /**
     * 根据ID查询人员信息
     *
     * @param id
     * @return
     */
    public Stuff queryStuff(Integer id);

    /**
     * 添加人员信息
     *
     * @return java.lang.Integer
     * @Description TODO
     * @Date 19:38 2020/3/26
     * @Param [stuff]
     **/
    public Integer addStuff(Stuff stuff);

    /**
     * 删除人员信息
     *
     * @param id
     * @return
     */
    public Integer deleteStuffById(Integer id);

    /**
     * 批量删除人员信息
     * @param ids
     * @return
     */
    Integer deleteStuffByIds(String ids);

    /**
     * 查询全部工作人员信息
     *
     * @return
     */
    public List<Stuff> queryAllStuff(Map<String, Object> map);

    /**
     * 按照职称查询工作人员信息
     *
     * @param rankName
     * @return
     */
    public List<Stuff> getQueryRankStuff(String rankName);

    /**
     * 修改人员信息
     *
     * @param stuff
     * @return
     */
    public Integer updateStuff(Stuff stuff);

    /**
     * 登陆接口
     * @param userName
     * @param password
     * @return
     */
    ResponseParam loginStuff(String userName,String password);


    Integer queryCount();

    /**
     * 根据科室ID查询全部工作人员信息
     *
     * @param id
     * @return
     */
    public List<Stuff> queryDoctorStuff(Integer id);

    /**
     * 修改密码
     * @param stuff
     * @return
     */
    public ResponseParam changePassword(Stuff stuff);
}
