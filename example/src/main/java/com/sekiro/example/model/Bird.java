package com.sekiro.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
public class Bird {

    private String myVar;

    public Bird(String myVar) {
        this.myVar = myVar;
    }

    public String sayHi() {
        return "Hi from the Brid class ==> myVar: " + myVar;
    }
}
