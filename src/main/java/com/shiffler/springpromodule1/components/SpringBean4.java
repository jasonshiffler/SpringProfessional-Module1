package com.shiffler.springpromodule1.components;

public class SpringBean4 {

    //Don't technically need this since this is the only constructor.
    //We would need it

    public SpringBean4(){
        System.out.println("I'm Spring Bean 4 built using a no-Arg Constructor ");
    }

    public void initMethod(){
        System.out.println("Init method for SpringBean4");
    }

    public void destroyMethod(){
        System.out.println("Destroy method for SpringBean4");
    }

}
