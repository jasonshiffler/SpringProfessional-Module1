//This Bean is used as an example of componentscan exclusion


package com.shiffler.scopesample.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringBean3 {


    @Autowired
    public SpringBean3(){

    }

}
