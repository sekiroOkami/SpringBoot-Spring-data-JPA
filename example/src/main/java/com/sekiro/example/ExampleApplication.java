package com.sekiro.example;


import com.sekiro.example.config.AppConfig;
import com.sekiro.example.service.MyFirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ExampleApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ExampleApplication.class, args);
//		var context = new AnnotationConfigApplicationContext(AppConfig.class);
//		Arrays.stream(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);
	}
}
