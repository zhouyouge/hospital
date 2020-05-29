package com.future.service.impl;

import com.future.dao.SickerDao;
import com.future.entity.Department;
import com.future.entity.Sicker;
import com.future.service.SickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*引入Service层*/
public class SickerServiceImpl implements SickerService {
    @Autowired
    SickerDao sickerDao;/*注入SickerDao接口*/

    @Override
    public List<Department> queryDepartment() {
        return sickerDao.queryDepartment();
    }

    @Override
    public List<Sicker> querySicker() { return sickerDao.querySicker(); }

    @Override
    public Integer deleteSicker(Integer sickerId) {return sickerDao.deleteSicker(sickerId);
    }

    @Override
    public Integer addSicker(Sicker sicker) { return sickerDao.addSicker(sicker);
    }

    @Override
    public Integer updateSicker(Sicker sicker) { return sickerDao.updateSicker(sicker);
    }
}
