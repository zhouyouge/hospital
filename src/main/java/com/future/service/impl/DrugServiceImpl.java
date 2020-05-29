package com.future.service.impl;

import com.future.dao.DrugDao;
import com.future.entity.Drug;
import com.future.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("drugService")
public class DrugServiceImpl implements DrugService {


    @Autowired
    private DrugDao drugDao;

    /**
     * 药品列表
     * @return
     */
    @Override
    public List<Drug> getDrList(Drug drug) {
        return drugDao.getDrugList(drug);
    }

    @Transactional
    @Override
    public Boolean addDrug(Drug drug) {
        drug.setTotalprice(drug.getBprice()*drug.getBatch());
        return drugDao.addDrug(drug)>0;

    }

    @Transactional
    @Override
    public Boolean delDrug(Drug drug) {
        if(StringUtils.isEmpty(drug.getId())){
            return false;
        }
        return drugDao.delDrug(drug)>0;
    }


    @Transactional
    @Override
    public Boolean updateDrug(Drug drug) {
        if(StringUtils.isEmpty(drug.getId())){
            return false;
        }
        return drugDao.updateDrug(drug)>0;
    }

}
