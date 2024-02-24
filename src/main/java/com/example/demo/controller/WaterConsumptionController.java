package com.example.demo.controller;

import com.example.demo.entity.Agua;
import com.example.demo.entity.Luz;
import com.example.demo.service.LuzService;
import com.example.demo.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/water")
public class WaterConsumptionController {
    @GetMapping
    public String luzSelect(Model model){
        model.addAttribute("water",waterService.aguaSelect());
        return "water_consumption";
    }
    @PostMapping("/water_insert")
    public String luzInsert(@Validated Agua agua, BindingResult bindingResult){
        System.out.println(agua);
        if(bindingResult.hasErrors())
            return "water_insert";
        waterService.aguaInsert(agua);
        return "redirect:/water";
    }

    @GetMapping("/new_register")
    public String waterForm(Model model) {
        model.addAttribute("agua",new Agua());
        return "water_insert";
    }

    @Autowired
    WaterService waterService;

}
