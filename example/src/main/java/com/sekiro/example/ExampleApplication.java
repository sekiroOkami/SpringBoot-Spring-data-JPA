package com.sekiro.example;

import com.sekiro.example.model.Bird;
import com.sekiro.example.services.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {
	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var context = app.run(args);
		MyService service = context.getBean(MyService.class);
//		var bird = context.getBean(Bird.class);
		System.out.println(service.tellAStory());
		System.out.println(service.getJavaVersion());
		System.out.println(service.getOsName());
		System.out.println(service.readPropertiesFile());
        System.out.println(service.getPropertiesInt());
        System.out.println(service.getCustomPropertyFromAnotherFile());
        System.out.println(service.getCustomPropertyFromAnotherFile2());
    }
}
