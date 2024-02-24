package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenDotaApiService {
    private final RestTemplate restTemplate;
    private final String API_BASE_URL;

    public OpenDotaApiService(RestTemplate restTemplate,@Value("${opendota.api.base-url}")String API_BASE_URL) {
        this.restTemplate = restTemplate;
        this.API_BASE_URL = API_BASE_URL;
    }

//    private static final String API_BASE_URL = "https://api.opendota.com/api/";
    public String getDetailHeroes(){
        String url = API_BASE_URL + "heroes";
        return restTemplate.getForObject(url, String.class);
    }
//    public String getDetailHeroes2(String attribute){
//        String heroesData = getDetailHeroes();
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Hero> heroes = new ArrayList<>();
//        try{
//            JsonNode rootNode = objectMapper.readTree(heroesData);
//            for(JsonNode node : rootNode){
//                String primaryAttribute = node.get("primary_attr").asText();
//                if(primaryAttribute.equalsIgnoreCase(attribute)){
//                    Hero hero = new Hero(
//                            node.get("id").asInt(),
//                            node.get("name").asText(),
//                            node.get("localized_name").asText(),
//                            node.get("attack_type").asText(),
//                            node.get("legs").asText()
//                    );
//                }
//            }
//
//        }
//        catch(Exception e){
//            return e.toString();
//        }
//    }
}
