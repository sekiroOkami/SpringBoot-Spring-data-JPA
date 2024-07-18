package com.sekiro.example.configs;

import com.sekiro.example.model.Bird;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class AppConfig {
    @Bean
//    @Qualifier("bean1")
    public Bird bird1() {
        return new Bird("bird1");
    }

    @Bean("bean2")
//    @Qualifier("bean2")
    public Bird bird2() {
        return new Bird("bird2");
    }

    @Bean
//    @Primary
    public Bird primaryBird() {
        return new Bird("primaryBird");
    }
}
