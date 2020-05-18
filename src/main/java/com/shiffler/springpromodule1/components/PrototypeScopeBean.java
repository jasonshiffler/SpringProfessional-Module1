package com.shiffler.springpromodule1.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeScopeBean {

    public PrototypeScopeBean(){
        System.out.println("I'm a new Prototype Scope Bean");
    }

}
