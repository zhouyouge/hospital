package com.future.service.impl;

import com.future.dao.IllnessDao;
import com.future.entity.Illness;
import com.future.entity.IllnessType;
import com.future.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangchenxiang
 *  2020-03-28
 */
@Service
public class IllnessServiceImpl implements IllnessService {

    /**
     * 疾病类service层
     */
    @Autowired
    IllnessDao illnessDao;

    /**
     * 返回疾病类型列表
     */
    @Override
    public List<IllnessType> getIllnessTypeList(IllnessType illnessType) {
        return illnessDao.getIllnessTypeList(illnessType);
    }

    @Override
    public List<Illness> getIllnessByTypeId(Illness illness) {
        return illnessDao.getIllnessByTypeId(illness);
    }

    @Override
    public Boolean addIllnessType(IllnessType illnessType) {
        List<IllnessType> list =illnessDao.getIllnessTypeList(illnessType);
        if (list!=null&&list.size()>0){
            return false;
        }
        return illnessDao.addIllnessType(illnessType)>0;
    }

    @Override
    public Boolean delIllnessType(IllnessType illnessType) {
        if (illnessType==null){
            return false;
        }
        if (illnessType.getId()==null){
            return false;
        }else if(illnessType.getId()<=0){
            return false;
        }
        Illness illness = new Illness();
        illness.setTypeid(illnessType.getId());
        List<Illness> list = illnessDao.getIllnessByTypeId(illness);
        if (list!=null&&list.size()>0){
            return false;
        }
        return illnessDao.delIllnessType(illnessType)>0;
    }

    @Override
    public Boolean updateIllnessType(IllnessType illnessType) {
        return illnessDao.updateIllnessType(illnessType)>0;
    }

    @Override
    public Boolean addIllness(Illness illness) {
        if (illness==null){
            return false;
        }else if (illness.getName()==null){
            return false;
        }
        List<Illness> list = illnessDao.getIllnessByTypeId(illness);
        if (list!=null&&list.size()>0){
            return false;
        }
        return illnessDao.addIllness(illness)>0;
    }

    @Override
    public Boolean delIllness(Illness illness) {
        return illnessDao.delIllness(illness)>0;
    }

    @Override
    public Boolean updateIllness(Illness illness) {
        return illnessDao.updateIllness(illness)>0;
    }
}
