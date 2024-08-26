package com.sekiro.example;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ExampleApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ExampleApplication.class, args);
//		var context = new AnnotationConfigApplicationContext(AppConfig.class);
//		Arrays.stream(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);
	}
}
