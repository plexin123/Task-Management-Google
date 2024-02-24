package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class DeepLService {
    @Value("${deepl.api.key}")
    private String apiKey;

    @Value("${deepl.api.key.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public DeepLService(RestTemplate restTemplate)  {
        this.restTemplate = restTemplate;
    }

    public String translateText(String text, String sourceLang, String targetLang) {
        if(text == null || sourceLang == null || targetLang == null)
            return "You have to fill all the parameters";
        try {
            // Create the request headers with the API key
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "DeepL-Auth-Key " + apiKey);

            // Create the HTTP entity with the request headers
            HttpEntity<String> entity = new HttpEntity<>(null, headers);

            // Build the URL with query parameters
            String url = baseUrl + "?text=" + text + "&source_lang=" + sourceLang + "&target_lang=" + targetLang;

            // Send a POST request with the API key in the headers
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            String response = responseEntity.getBody();

            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }


}

