package com.shiffler.scopesample.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean2 {

    public SpringBean2(){
        System.out.println("I'm a new Spring Bean 2");
    }

    //Q5 - Runs after the constructor has been run
    @PostConstruct
    public void postConstruct(){
        System.out.println("Spring Bean 2 PostConstruct");
    }

    //Q5 - Runs before the application context shuts down.
    @PreDestroy
    public void preDestroy(){
        System.out.println("Spring Bean 2 PreDestroy");
    }
}
