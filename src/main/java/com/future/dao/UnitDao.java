package com.future.dao;

import com.future.entity.Unit;

import java.util.List;

public interface UnitDao {
    List<Unit> getUnitList(Unit unit);
}
