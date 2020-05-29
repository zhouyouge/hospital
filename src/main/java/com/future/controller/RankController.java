package com.future.controller;


import com.future.entity.Stuff;
import com.future.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author NieJingGuo
 * @Description TODO 职称前端控制器
 * @Date 16:25 2020/3/26
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/rank")
public class RankController {

    @Autowired
    IRankService iRankService;

    @RequestMapping(value = "/queryRank",method = RequestMethod.GET)
    public List<Stuff> queryRank(){
        List<Stuff> stuffList = iRankService.queryRank();
        return stuffList;
    }

}
