package com.narne.tracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.narne.tracker.domain.Pet;
import com.narne.tracker.form.PetForm;
import com.narne.tracker.services.PetService;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class PetController {
    private PetService petService;

    @Autowired
    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/pet/list";
    }

    @RequestMapping({"/pet/list", "/pet"})
    public String listPets(Model model){
        model.addAttribute("pets", petService.listAll());
        return "pet/list";
    }

    @RequestMapping("/pet/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("pet", petService.getById(id));
        return "pet/show";
    }

    @RequestMapping("/pet/new")
    public String newProduct(Model model){
        model.addAttribute("petForm", new PetForm());
        return "pet/petForm";
    }

    @RequestMapping("/pet/delete/{id}")
    public String delete(@PathVariable String id){
        petService.delete(id);
        return "redirect:/pet/list";
    }
    
    @RequestMapping("pet/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Pet pet = petService.getById(id);
        PetForm petForm = new PetForm();
        
        petForm.setId(pet.getId().toHexString());
        petForm.setBirthday(pet.getBirthday());
        petForm.setName(pet.getName());
        petForm.setSpecies(pet.getSpecies());

        model.addAttribute("petForm", petForm);
        return "pet/petForm";
    }
    
    @RequestMapping("/pet/showDoctorVisits/{id}")
    public String showVisits(@PathVariable String id, Model model){
        Pet pet = petService.getById(id);
        PetForm petForm = new PetForm();
        
        petForm.setId(pet.getId().toHexString());
        petForm.setBirthday(pet.getBirthday());
        petForm.setName(pet.getName());
        petForm.setSpecies(pet.getSpecies());

        model.addAttribute("petForm", petForm);
        return "pet/petForm";
    }
    
    
    
    @RequestMapping(value = "/pet", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid PetForm petForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "pet/petForm";
        }

        Pet savedPet = petService.saveOrUpdatePetForm(petForm);

        return "redirect:/pet/show/" + savedPet.getId();
    }
}
