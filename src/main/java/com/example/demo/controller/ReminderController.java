package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.GmailSenderService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/reminders")
public class ReminderController {
    @Autowired
    private GmailSenderService gmailSenderService;
    @Autowired
    private TaskService taskService;
    @PostMapping("/send-reminder")
    public  String sendReminder(){
        List<Task> tasks = taskService.getAll();
        //Send a reminder email  with this  list of tasks
        gmailSenderService.sendReminder("demo2","ypl22-@hotmail.com",tasks);
        return "it worked";
    }
}
