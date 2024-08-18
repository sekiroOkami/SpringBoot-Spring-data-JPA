package com.sekiro.example.config;

import com.sekiro.example.model.MyFirstClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("bean1")
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First bean");
    }

    @Bean
    @Qualifier("bean2")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("nd bean");
    }

//    @Bean
//    @Primary
//    @Qualifier("bean3")
//    public MyFirstClass myThirdBean() {
//        return new MyFirstClass("rd bean");
//    }
}
