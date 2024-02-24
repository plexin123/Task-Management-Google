package com.example.demo.controller;

import com.example.demo.service.DeepLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class DeepLController {
    private final DeepLService deepLService;

    @Autowired //dependency injection constructor
    public DeepLController(DeepLService deepLService) {
        this.deepLService = deepLService;
    }

    @PostMapping
    public String translate(
            @RequestParam String text,
            @RequestParam String sourceLang,
            @RequestParam String targetLang
    ) {
        return deepLService.translateText(text, sourceLang, targetLang);
    }
}
