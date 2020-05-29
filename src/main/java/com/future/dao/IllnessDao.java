package com.future.dao;

import com.future.entity.Illness;
import com.future.entity.IllnessType;

import java.util.List;

public interface IllnessDao {
    List<IllnessType> getIllnessTypeList(IllnessType illnessType);

    List<Illness> getIllnessByTypeId(Illness illness);

    int addIllnessType(IllnessType illnessType);

    int delIllnessType(IllnessType illnessType);

    int updateIllnessType(IllnessType illnessType);

    int addIllness(Illness illness);

    int delIllness(Illness illness);

    int updateIllness(Illness illness);


}
