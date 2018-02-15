package com.narne.tracker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.narne.tracker.domain.DoctorVisit;

public interface DoctorVisitRepository extends MongoRepository<DoctorVisit, String> {

	Iterable<DoctorVisit> findByPetId(String petId);
	
}
