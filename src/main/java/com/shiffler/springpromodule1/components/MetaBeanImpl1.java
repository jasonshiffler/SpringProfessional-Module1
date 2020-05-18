package com.shiffler.springpromodule1.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //Q14 - If there are multiple implementations of the Metabean interface then this class will be
         //preferred.
public class MetaBeanImpl1 implements MetaBean{
    @Override
    public void sayMyName() {
        System.out.println("I'm a MetaBeanImpl1");

    }
}
