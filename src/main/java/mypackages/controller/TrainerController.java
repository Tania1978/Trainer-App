/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackages.controller;

import java.util.List;

import javax.validation.Valid;
import mypackages.entity.Trainer;
import mypackages.service.TrainerService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
    
    @Autowired
    private TrainerService service;
    
    @RequestMapping
    public String showTrainers(Model model){
      List<Trainer> trainers =   service.showTrainers();
      model.addAttribute("trainers", trainers);
      return "trainerstable";
    }
    
    @PostMapping("/create")
    public String createTrainer(@Valid @ModelAttribute("trainer") Trainer trainer,  BindingResult result, RedirectAttributes attributes){
          if(result.hasErrors()){
            return "trainerform";
        }
         service.createTrainer(trainer);
        String message = "Trainer " + trainer.getFirstName() + " " + trainer.getLastName() + " created Successfully!";
        attributes.addFlashAttribute("message",message);
        return "redirect:/trainer";
    }
    
    @GetMapping("/create")
    public String showTrainerForm(Model model){
        Trainer trainer = new Trainer();
        model.addAttribute("trainer", trainer);
        return "trainerform";
    
}
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name="id") int id, Trainer trainer, RedirectAttributes attributes){
        trainer= service.findById(id);
        service.delete(id); 
        String message="Trainer " + trainer.getFirstName() + " " + trainer.getLastName() + " deleted Successfully!";
       attributes.addFlashAttribute("message", message);
         return "redirect:/trainer";
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable(name="id") int id, Model model){
        Trainer trainer = service.findById(id);
        model.addAttribute("trainer", trainer);
        return "trainerform";
    }
    
    @PostMapping("/update")
    public String updateTrainer(@Valid Trainer trainer,  BindingResult result, RedirectAttributes attributes){
            if(result.hasErrors()){
            return "trainerform";
        }

        trainer =service.updateTrainer(trainer);
          String message = "Trainer was updated Successfully!";
        attributes.addFlashAttribute("message",message);
        return "redirect:/trainer";
    }
    
     @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
        String minima = "Could not commit transaction!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
    @ModelAttribute(name="subjects")
    public List<String> getSubjects(){
         List<String> subjects= service.getSubjects();
         return subjects;
    }
    
      @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolationException(RedirectAttributes attributes) {
        String minima = "Vat Number Already Exists - Could Not commit transaction.";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
    }

