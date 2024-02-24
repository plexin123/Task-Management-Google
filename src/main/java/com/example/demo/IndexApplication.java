package com.example.demo;

import com.example.demo.entity.Task;
import com.example.demo.service.GmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class IndexApplication {
	@Autowired
	private GmailSenderService gmailSenderService;

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(IndexApplication.class, args);
		Arrays.stream(app.getBeanDefinitionNames()).forEach(System.out::println);
	}
	@Bean
	public WebMvcConfigurer configure(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendEmail() {
//		gmailSenderService.sendEmail("Demo1", "ypl22-@hotmail.com", "READY TO GO");
//		gmailSenderService.sendReminder("Demo2", "ypl22-@hotmail.com",//what should I add? );
//	}
}