package com.narne.tracker.services;

import java.util.List;

import com.narne.tracker.domain.DoctorVisit;
import com.narne.tracker.form.DoctorVisitForm;

public interface DoctorVisitService {

    List<DoctorVisit> listAll(String id);

    DoctorVisit getById(String id);

    DoctorVisit saveOrUpdate(DoctorVisit doctorVisit);

    void delete(String id);
    
    DoctorVisit saveOrUpdateDoctorVisitForm(DoctorVisitForm doctorVisitForm);
}
