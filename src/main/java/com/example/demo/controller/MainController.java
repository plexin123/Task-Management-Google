package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public String generateUser(){
        User user = new User();
        user.setUsername("sad");
        user.setPassword(bCryptPasswordEncoder.encode("123"));
        user.setRole("ADMIN");
        user.setEnabled(true);
        userService.insert(user);
        return user.getUsername();
    }

    @PostMapping("/logout")
    public String logout(){
        return "salimos";
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String holamundo(){
        return "holas";

    }
    @GetMapping(value = "/saludo",produces = MediaType.TEXT_PLAIN_VALUE)

    public String saludo( @RequestParam("nom") String x){
        return "hola " + x;
    }
    @GetMapping(value = "/saludos",produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo2(@RequestParam("nom") String x,@RequestParam("app") Double y ){
        String rest = "text ";
        for (int i = 0; i < y ; i++) {
            rest += x;
        }
        return rest;
    }
    @GetMapping(value = "/duplicar/{numero}",produces = MediaType.TEXT_PLAIN_VALUE)
    public String duplicar(@PathVariable("numero") Integer numero){
        return String.valueOf(2*numero);
    }


}
