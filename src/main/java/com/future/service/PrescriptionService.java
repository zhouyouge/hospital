package com.future.service;

import com.future.entity.Cure;
import com.future.entity.Prescription;
import com.future.entity.Result;

import java.util.List;

public interface PrescriptionService {

    List<Prescription> getList(Prescription prescription);

    Boolean addPre(Prescription prescription);

    Boolean modPre(Prescription prescription);

    List<Prescription> getCureType();

    List<Cure> getUseage();

    int getCount(Prescription prescription);

    int addPrescription(Prescription prescription);


}
