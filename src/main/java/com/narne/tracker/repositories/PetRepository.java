package com.narne.tracker.repositories;

import org.springframework.data.repository.CrudRepository;

import com.narne.tracker.domain.Pet;

public interface PetRepository extends CrudRepository<Pet, String> {
}
