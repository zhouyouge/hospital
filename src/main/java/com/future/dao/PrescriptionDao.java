package com.future.dao;

import com.future.entity.Cure;
import com.future.entity.Prescription;

import java.util.List;

public interface PrescriptionDao {

    List<Prescription> getList(Prescription prescription);

    int getCount(Prescription prescription);

    int addPrescription(Prescription prescription);

    int modPrescription(Prescription prescription);

    List<Prescription> getCureType();

    List<Cure> getUseage();

}
