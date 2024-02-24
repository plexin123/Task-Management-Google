package com.example.demo.controller;

import com.example.demo.entity.Luz;
import com.example.demo.service.LuzService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/energy")
public class EnergyConsumptionController {
    @GetMapping
    public String luzSelect(Model model){
        model.addAttribute("energy",luzService.luzSel());
        return "energy_consumption";
    }
    @PostMapping("/energy_insert")
    public String luzInsert(@Validated Luz luz, BindingResult bindingResult){
        System.out.println(luz);
        if(bindingResult.hasErrors())
            return "energy_insert";
        luzService.luzInsertUpdate(luz);
        return "redirect:/energy";
        }

   @GetMapping("/new_register")
   public String luzForm(Model model) {
        model.addAttribute("luz",new Luz());
        return "energy_insert";
   }
   @GetMapping("/edit_register/{id}")
   public String luzFormA(Model model, @PathVariable("id") Integer id){
        model.addAttribute("luz", luzService.luzGet(id));
        return "energy_insert";
   }
   @GetMapping("/delete")
   public String deleteObject(Model model, @RequestParam("id") Integer id) {
        luzService.luzDelete(id);
        return "redirect:/energy";
   }

    @Autowired
    LuzService luzService;

}
