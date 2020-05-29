package com.future.dao;

import com.future.entity.Stuff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StuffDao
 * @Description: TODO 工作人员DAO接口
 * @Author NieJingGuo
 * @Date 2020/3/26 15:49
 * @Version V1.0
 **/
public interface StuffDao {

    /**
     * 添加人员信息
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
     * 修改人员信息
     *
     * @param st
     * @return
     */
    public Integer updateStuff(@Param("st") Stuff st);

    /**
     * 根据ID查询工作人员信息
     *
     * @param id
     * @return
     */
    public Stuff queryStuff(Integer id);

    /**
     * 查询全部工作人员信息
     *
     * @return
     */
    public List<Stuff> queryAllStuff(@Param("params") Map<String, Object> params);

    /**
     * 登陆接口
     *
     * @param
     * @return
     */
   Stuff loginStuff(@Param("userName") String userName,@Param("password") String password);

    /**
     * 删除
     * @param ids
     * @return
     */
    Integer deleteStuffByIds(@Param("ids")String ids);

    /**
     * 查询人数
     * @return
     */
    Integer queryCount();

    /**
     * 根据科室ID查询全部工作人员信息
     *
     * @param id
     * @return
     */
    public List<Stuff> queryDoctorStuff(Integer id);

    public Integer changePassword(Stuff stuff);

}