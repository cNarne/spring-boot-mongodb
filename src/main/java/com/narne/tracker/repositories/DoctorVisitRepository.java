package com.narne.tracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.narne.tracker.domain.DoctorVisit;

public interface DoctorVisitRepository extends CrudRepository<DoctorVisit, String> {

	Iterable<DoctorVisit> findByPetId(String petId);
	
}
