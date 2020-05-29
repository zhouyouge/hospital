package com.future.dao;

import com.future.entity.Cure;

import java.util.List;

public interface CureDao {
    List<Cure> getList(Cure cure);

    int addCure(List<Cure> list);

    int delCure(Cure cure);

    int modCure(Cure cure);
}
