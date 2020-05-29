package com.future.dao;

import com.future.entity.Stuff;

import java.util.List;

/**
 * @ClassName RankDao
 * @Description: TODO 职称DAO接口
 * @Author NieJingGuo
 * @Date 2020/3/26 15:50
 * @Version V1.0
 **/
public interface RankDao {
    List<Stuff> queryRank();
}
