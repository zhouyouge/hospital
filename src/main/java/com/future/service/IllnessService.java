package com.future.service;

import com.future.entity.Illness;
import com.future.entity.IllnessType;

import java.util.List;

public interface IllnessService {
    List<IllnessType> getIllnessTypeList(IllnessType illnessType);

    List<Illness> getIllnessByTypeId(Illness illness);

    Boolean addIllnessType(IllnessType illnessType);

    Boolean delIllnessType(IllnessType illnessType);

    Boolean updateIllnessType(IllnessType illnessType);

    Boolean addIllness(Illness illness);

    Boolean delIllness(Illness illness);

    Boolean updateIllness(Illness illness);

}
