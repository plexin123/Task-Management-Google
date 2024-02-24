package com.example.demo.controller;

import com.example.demo.entity.Agua;
import com.example.demo.entity.Luz;
import com.example.demo.entity.Task;
import com.example.demo.service.LuzService;
import com.example.demo.service.TaskService;
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
@RequestMapping("/tasks")
public class TaskConsumptionController {
    @GetMapping
    public String luzSelect(Model model){
        model.addAttribute("tasks",taskService.getAll());
        return "task_consumption";
    }
    @PostMapping("/task_insert")
    public String luzInsert(@Validated Task task, BindingResult bindingResult){
        System.out.println(task);
        if(bindingResult.hasErrors())
            return "task_insert";
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/new_register")
    public String taskForm(Model model) {
        model.addAttribute("tasks",new Task());
        return "task_insert";
    }

    @Autowired
    TaskService taskService;

}
