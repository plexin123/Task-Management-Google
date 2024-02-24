package com.example.demo.service;

import com.example.demo.entity.Luz;
import com.example.demo.entity.Task;
import org.apache.logging.log4j.message.SimpleMessage;
import org.hibernate.boot.archive.scan.internal.ScanResultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GmailSenderService {
    @Value("${spring.mail.username}")
    private String sourceMail; //encapsulation
    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(String subject, String destinyMail, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sourceMail);
        message.setTo(destinyMail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("It worked");
    }

    public void sendReminder(String subject, String destinyMail, List<Task> tasks) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sourceMail);
        message.setTo(destinyMail);
        message.setSubject(subject);
        String body = formatTaksReminder(tasks);
        message.setText(body);
        mailSender.send(message);
        System.out.println("reminder sent to" + destinyMail);
    }

    public void sendReminderA(String subject, String destinyMail, List<Luz> luces) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sourceMail);
        message.setTo(destinyMail);
        message.setSubject(subject);
        String body = formatLuz(luces);
        message.setText(body);
        mailSender.send(message);
        System.out.println("reminderA sent to" + destinyMail);

    }

    private String formatTaksReminder(List<Task> tasks) {
        StringBuilder body = new StringBuilder("Reminder of your tasks:\n");
        for (Task task : tasks) {
            body.append("-").append(task.getTitle()).append(" \n")
                    .append(task.getDescription())
                    .append(" \n")
                    .append(task.getDueDate());
        }
        return body.toString();
    }

    private String formatLuz(List<Luz> list) {
        StringBuilder body = new StringBuilder("List of Energy Consumption:\n");
        for (Luz luz : list) {
            body.append("- Casa: ").append(luz.getCasa())
                    .append(", Piso: ").append(luz.getPiso())
                    .append(", Importe: ").append(luz.getImporte())
                    .append(", Fecha de Inicio: ").append(luz.getStartDate())
                    .append(", Fecha de Cierre: ").append(luz.getEndDate())
                    .append("\n");
        }
        return body.toString();
    }
}

