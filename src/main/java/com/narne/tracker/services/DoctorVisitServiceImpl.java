package com.narne.tracker.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.narne.tracker.domain.DoctorVisit;
import com.narne.tracker.form.DoctorVisitForm;
import com.narne.tracker.repositories.DoctorVisitRepository;

@Service
public class DoctorVisitServiceImpl implements DoctorVisitService {

    private DoctorVisitRepository doctorVisitRepository;

    @Autowired
    public DoctorVisitServiceImpl(DoctorVisitRepository doctorVisitRepository) {
        this.doctorVisitRepository = doctorVisitRepository;
    }

    @Override
    public List<DoctorVisit> listAll(String id) {
        List<DoctorVisit> visits = new ArrayList<>();
        doctorVisitRepository.findByPetId(id).forEach(visits::add);
        return visits;
    }

    @Override
    public DoctorVisit getById(String id) {
        return doctorVisitRepository.findById(id).orElse(null);
    }

    @Override
    public DoctorVisit saveOrUpdate(DoctorVisit visit) {
    	doctorVisitRepository.save(visit);
        return visit;
    }

    @Override
    public void delete(String id) {
    	doctorVisitRepository.deleteById(id);
    }
    
    @Override
    public DoctorVisit saveOrUpdateDoctorVisitForm(DoctorVisitForm doctorVisitForm) {
    	DoctorVisit doctorVisit = new DoctorVisit();
        if(doctorVisitForm.getPetId() != null && !StringUtils.isEmpty(doctorVisitForm.getPetId())) {
        	doctorVisit.setPetId(doctorVisitForm.getPetId());
        }
        doctorVisit.setDoctorName(doctorVisitForm.getDoctorName());
        doctorVisit.setVisitDate(doctorVisitForm.getVisitDate());
        doctorVisit.setVisitReason(doctorVisitForm.getVisitReason());
        doctorVisit = saveOrUpdate(doctorVisit);
        return doctorVisit;
    }
}
