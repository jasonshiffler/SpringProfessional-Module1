package com.shiffler.springpromodule1.components;

import org.springframework.stereotype.Component;

@Component
public class MetaBeanImpl2 implements MetaBean{
    @Override
    public void sayMyName() {
        System.out.println("I'm a MetaBeanImpl2");

    }
}
