package com.future.service.impl;

import com.future.dao.DrugtransDao;
import com.future.entity.Drugtrans;
import com.future.service.DrugtransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("drugtransService")
public class DrugtransServiceImpl implements DrugtransService {

    @Autowired
    private DrugtransDao drugtransDao;

    /**
     * 药品交易记录列表
     * @param drugtrans
     * @return
     */
    @Override
    public List<Drugtrans> getDrugtransList(Drugtrans drugtrans) {
        return drugtransDao.getDrugtransList(drugtrans);
    }

    @Transactional
    @Override
    public Boolean addDrugtrans(Drugtrans drugtrans) {
        drugtrans.setId(drugtrans.getId());
        return drugtransDao.addDrugtrans(drugtrans)>0;
    }

    @Transactional
    @Override
    public Boolean delDrugtrans(Drugtrans drugtrans) {
        if (StringUtils.isEmpty(drugtrans.getId())){
            return false;
        }
        return drugtransDao.delDrugtrans(drugtrans)>0;
    }

    @Transactional
    @Override
    public Boolean updateDrugtrans(Drugtrans drugtrans) {
        if (StringUtils.isEmpty(drugtrans.getId())){
            return false;
        }
        return drugtransDao.updateDrugtrans(drugtrans)>0;
    }

}
