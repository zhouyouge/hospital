package com.future.service;

import com.future.entity.Cure;

import java.util.List;

public interface CureService {
    List<Cure> getList(Cure cure);

    int addCure(List<Cure> list);

}
