package com.narne.tracker.services;

import java.util.List;

import com.narne.tracker.domain.Pet;
import com.narne.tracker.form.PetForm;

public interface PetService {

    List<Pet> listAll();

    Pet getById(String id);

    Pet saveOrUpdate(Pet pet);

    void delete(String id);
    
    Pet saveOrUpdatePetForm(PetForm petForm);

}
