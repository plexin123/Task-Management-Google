package com.example.demo.controller;

import com.example.demo.entity.Luz;
import com.example.demo.entity.Task;
import com.example.demo.service.GmailSenderService;
import com.example.demo.service.LuzService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private GmailSenderService gmailSenderService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private LuzService luzService;
    private boolean remind = false;
    @Autowired
    @Value("${spring.mail.destiny}")
    private String mailDestiny;
    @Autowired
    @Value("${spring.mail.username}")
    private String mailMe;

    @GetMapping("correo1")
    public String sendCorreo(){
           executeReminderLogic();
           remind = true;
            return "correo1";
    }
    @Scheduled(fixedRate = 60000)
    public void SendCorreoA1(){
       executeReminderLogic();
    }
    private void executeReminderLogic() {
        List<Task> tasks = taskService.getAll();
        if (remind) {
            if (TaskCompleted(tasks)) {
                 return;
            }
            else {
                List<Task> taskleft = taskService.tasknotCompleted(tasks);
                gmailSenderService.sendReminder("Task_List", mailMe, taskleft);
                remind = false;
            }
        }
    }
    @GetMapping("correo")
    public String sendCorreoB(){
        List<Luz> luces = luzService.luzSel();
        gmailSenderService.sendReminderA("Lista de luces",mailDestiny,luces);
        remind = true;
        return "correo";
    }
    @Scheduled(fixedDelay = 600000) //1 m in milliseconds
    public void sendCorreoB1(){
        if(remind) {
            List<Luz> luces = luzService.luzSel();
            gmailSenderService.sendReminderA("Lista de luces", mailDestiny, luces);
            remind = false;
        }
    }

    public boolean TaskCompleted(List<Task> tasks){
        for(Task task :tasks){
            if(!(task.isCompleted()))
                return false;
        }
        return true;
    }

}//TaskFlow Manager
