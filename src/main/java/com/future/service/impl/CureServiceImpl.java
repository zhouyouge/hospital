package com.future.service.impl;

import com.future.dao.CureDao;
import com.future.entity.Cure;
import com.future.service.CureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CureServiceImpl implements CureService {

    @Autowired
    CureDao cureDao;

    @Override
    public List<Cure> getList(Cure cure) {
        return cureDao.getList(cure);
    }

    @Override
    public int addCure(List<Cure> list) {
        return cureDao.addCure(list);
    }
}
