package com.future.service;


import com.future.entity.Stuff;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 职称服务层接口
 * @Date 15:57 2020/3/26
 * @Param
 * @return
 **/
public interface IRankService {
    List<Stuff> queryRank();
}
