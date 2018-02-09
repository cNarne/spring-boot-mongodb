package com.narne.tracker.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.narne.tracker.domain.Pet;
import com.narne.tracker.form.PetForm;
import com.narne.tracker.repositories.PetRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> listAll() {
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet getById(String id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet saveOrUpdate(Pet pet) {
        petRepository.save(pet);
        return pet;
    }

    @Override
    public void delete(String id) {
        petRepository.deleteById(id);
    }
    
    @Override
    public Pet saveOrUpdatePetForm(PetForm petForm) {
        Pet savedPet = new Pet();
        if(petForm.getId() != null && !StringUtils.isEmpty(petForm.getId())) {
        savedPet.setId(new ObjectId(petForm.getId()));
        }
        savedPet.setBirthday(petForm.getBirthday());
        savedPet.setName(petForm.getName());
        savedPet.setSpecies(petForm.getSpecies());
        savedPet = saveOrUpdate(savedPet);
        return savedPet;
    }
}
