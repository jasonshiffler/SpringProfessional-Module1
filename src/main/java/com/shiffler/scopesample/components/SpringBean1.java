package com.shiffler.scopesample.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class SpringBean1 {


    public SpringBean1(){
        System.out.println("I'm a new Spring Bean 1");
    }



}
