package com.sekiro.example.services;

import com.sekiro.example.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
})
public class MyService {

    private final Bird bird;
    private Environment environment;

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public void setCustomPropertyFromAnotherFile(String customPropertyFromAnotherFile) {
        this.customPropertyFromAnotherFile = customPropertyFromAnotherFile;
    }

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("${my.prop.2}")
    private String customPropertyFromAnotherFile2;
    @Value("${my.prop.int}")
    private Integer propertiesInt;

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    public void setCustomPropertyFromAnotherFile2(String customPropertyFromAnotherFile2) {
        this.customPropertyFromAnotherFile2 = customPropertyFromAnotherFile2;
    }

    public Integer getPropertiesInt() {
        return propertiesInt;
    }


    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    public MyService(
           @Qualifier("bird1") Bird bird
    ) {
        this.bird = bird;
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String readPropertiesFile() {
        return environment.getProperty("my.custom.property");
    }

    public String tellAStory() {
        return "the dependency is saying: " + bird.sayHi();
    }
}
