package com.future.service.impl;

import com.future.dao.CureDao;
import com.future.dao.PrescriptionDao;
import com.future.entity.Cure;
import com.future.entity.Prescription;
import com.future.entity.Result;
import com.future.service.IStuffService;
import com.future.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    PrescriptionDao prescriptionDao;
    @Autowired
    CureDao cureDao;
    @Autowired
    IStuffService stuffService;


    @Override
    public List<Prescription> getList(Prescription prescription) {
        if (StringUtils.isEmpty(prescription)){
            return null;
        }
        if (StringUtils.isEmpty(prescription.getStaffid())){
            return null;
        }


        return prescriptionDao.getList(prescription);
    }

    @Override
    public Boolean addPre(Prescription prescription) {
        return null;
    }

    @Override
    public Boolean modPre(Prescription prescription) {
        return null;
    }

    @Override
    public List<Prescription> getCureType() {
        return prescriptionDao.getCureType();
    }

    @Override
    public List<Cure> getUseage() {
        return prescriptionDao.getUseage();
    }

    @Override
    public int getCount(Prescription prescription) {
        return prescriptionDao.getCount(prescription);
    }

    @Override
    public int addPrescription(Prescription prescription) {
        Result result = new Result();
        if(prescription.getTypeid()<=0||prescription.getStaffid()<=0){
            return 0;
        }else if (prescription.getSickerid()<=0||prescription.getIllnessid()<=0){
            return 0;
        }else {
            int flag = prescriptionDao.addPrescription(prescription);
            if (flag>0){
                return flag;
            }else{
                return 0;
            }
        }
    }
}
