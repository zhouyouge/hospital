package com.future.service.impl;

import com.future.dao.UnitDao;
import com.future.entity.Unit;
import com.future.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitDao unitDao;


    @Override
    public List<Unit> getUnitList(Unit unit) {
        return unitDao.getUnitList(unit);
    }
}
