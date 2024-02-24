package com.example.demo.configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DeepLConfig {
    @Value("${deepl.api.key.base-url}")
    public String openaiApiKey2;

    @Bean
    @Qualifier("deepLConfig")
    public RestTemplate deepLRestTemplate() {
            return new RestTemplate();
        }

    }

