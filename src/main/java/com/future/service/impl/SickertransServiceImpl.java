package com.future.service.impl;

import com.future.dao.SickertransDao;
import com.future.entity.Sickertrans;
import com.future.service.SickerService;
import com.future.service.SickertransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class SickertransServiceImpl implements SickertransService {
    @Autowired
    SickertransDao sickertransDao;
    @Override
    public List<Sickertrans> querySickertrans() { return sickertransDao.querySickertrans(); }

    @Override
    public Integer deleteSickertrans(Integer sickertransId) { return sickertransDao.deleteSickertrans(sickertransId);
    }

    @Override
    public Integer addSickertrans(Sickertrans sickertrans) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);
        sickertrans.setTransdate(date);


        return sickertransDao.addSickertrans(sickertrans);
    }

    @Override
    public Integer updateSickertrans(Sickertrans sickertrans) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);
        sickertrans.setTransdate(date);

        return sickertransDao.updateSickertrans(sickertrans);
    }
}
