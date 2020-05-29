package com.future.service;

import com.future.entity.Unit;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UnitService {
    List<Unit> getUnitList(Unit unit);

}
