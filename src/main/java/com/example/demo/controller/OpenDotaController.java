package com.example.demo.controller;

import com.example.demo.service.OpenDotaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenDotaController {

    @Autowired
    private OpenDotaApiService openDotaApiService;

    @GetMapping("/getheroes")
    public String getHeroes() {
        return openDotaApiService.getDetailHeroes();
    }
    @GetMapping("/getheroes/{atribute}")
    public String geHeroesWithAtribute(@PathVariable("atribute") String a) { //?atribut=

        return openDotaApiService.getDetailHeroes();
    }
}
