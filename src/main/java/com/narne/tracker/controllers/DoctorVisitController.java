package com.narne.tracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.narne.tracker.domain.DoctorVisit;
import com.narne.tracker.form.DoctorVisitForm;
import com.narne.tracker.services.DoctorVisitService;

@Controller
public class DoctorVisitController {
    private DoctorVisitService doctorVisitService;

    @Autowired
    public void setDoctorVisitService(DoctorVisitService doctorVisitService) {
        this.doctorVisitService = doctorVisitService;
    }

    @RequestMapping("/doctor")
    public String redirToList(){
        return "redirect:/doctor/list";
    }

    @RequestMapping({"/doctor/list/{id}", "/doctor"})
    public String listVisits(@PathVariable String id, Model model){
        model.addAttribute("doctorVisits", doctorVisitService.listAll(id));
        return "doctor/list";
    }

    @RequestMapping("/doctor/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("doctorVisits", doctorVisitService.listAll(id));
        return "doctor/list/{id}";
    }

    @RequestMapping("/doctor/new/{id}")
    public String newProduct(@PathVariable String id, Model model){
        model.addAttribute("doctorForm", new DoctorVisitForm(id));
        return "doctor/doctorForm";
    }

    @RequestMapping("/doctor/delete/{id}")
    public String delete(@PathVariable String id){
    	doctorVisitService.delete(id);
        return "redirect:/doctor/list";
    }
    
    @RequestMapping("doctor/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        DoctorVisit doctorVisit = doctorVisitService.getById(id);
        DoctorVisitForm doctorVisitForm = new DoctorVisitForm(id);
        
        doctorVisitForm.setDoctorName(doctorVisit.getDoctorName());
        doctorVisitForm.setVisitDate(doctorVisit.getVisitDate());
        doctorVisitForm.setVisitReason(doctorVisit.getVisitReason());

        model.addAttribute("doctorVisitForm", doctorVisitForm);
        return "doctor/doctorForm";
    }
    
//    @RequestMapping("/doctor/showDoctorVisits/{id}")
//    public String showVisits(@PathVariable String id, Model model){
//        List<DoctorVisit> doctorVisits = doctorVisitService.listAll(id);
//        DoctorVisitForm doctorVisitForm = new DoctorVisitForm(id);
//        
//     //   doctorVisitForm.setPetId(id);
////        doctorVisitForm.setDoctorName(doctorVisit.getDoctorName());
////        doctorVisitForm.setVisitDate(doctorVisit.getVisitDate());
////        doctorVisitForm.setVisitReason(doctorVisit.getVisitReason());
//
//        model.addAttribute("doctorVisitForm", doctorVisitForm);
//        return "doctor/doctorForm";
//    }
//    
    
    
    @RequestMapping(value = "/doctor", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid DoctorVisitForm doctorVisitForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "doctor/doctorForm";
        }

        DoctorVisit doctorVisit = doctorVisitService.saveOrUpdateDoctorVisitForm(doctorVisitForm);

        return "redirect:/doctor/show/" + doctorVisit.getPetId();
    }
}
