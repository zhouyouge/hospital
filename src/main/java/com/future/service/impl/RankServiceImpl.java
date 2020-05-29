package com.future.service.impl;

import com.future.dao.RankDao;
import com.future.entity.Stuff;
import com.future.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 职称服务实现类
 * @Date 16:19 2020/3/26
 * @Param
 * @return
 **/
@Service
public class RankServiceImpl implements IRankService {

    @Autowired
    RankDao rankDao;

    @Override
    public List<Stuff> queryRank() {
        List<Stuff> stuffList = rankDao.queryRank();
        return stuffList;
    }
}
