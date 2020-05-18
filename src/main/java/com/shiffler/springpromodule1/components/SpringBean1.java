package com.shiffler.springpromodule1.components;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean1 implements DisposableBean {

    private PrototypeScopeBean prototypeScopeBean;
    private MetaBean metaBean;
    private SpringBean4 springBean4;

    //Q10 - Retrieving a value from a property file
    @Value("${test.property}")
    private String propertyValue;

    //Q10 -Retrieving an environment variable
    @Value("${LANGUAGE}")
    private String language;

    //Q27 Injection using Spring Expression Language - SPeL
    @Value("#{'uno'}")
    private String beanStringInjection;

    //Q27 Injection using Spring Expression Language - SPeL
    @Value("#{4 * 3457}")
    private Integer beanIntegerInjection;


    //Since there are two constructors @Autowired signals to Spring which one should be called so that the
    //dependencies are injected.
    //Q16 - @Qualifier allows us to control which MetaBean implementation should be injected.
    @Autowired
    public SpringBean1(PrototypeScopeBean prototypeScopeBean, @Qualifier("metaBeanImpl2") MetaBean metaBean){
        this.prototypeScopeBean = prototypeScopeBean;
        this.metaBean = metaBean;
        System.out.println("I'm a new Spring Bean 1 built using Autowired Constructor");
    }

    public SpringBean1(){
        System.out.println("I'm a new Spring Bean 2 built using no-Arg Constructor");
    }

    //Q14 - Example of Setter based injection
    @Autowired
    public void set4(SpringBean4 springBean4){
        System.out.println("Spring Bean 1 setting SpringBean4 dependency " + springBean4);
        this.springBean4 = springBean4;
    }


    //Q5 - Runs after the constructor has been run
    @PostConstruct
    public void postConstruct(){
        System.out.println("Spring Bean 1 PostConstruct");
        System.out.println("Property Value is " + propertyValue);
        System.out.println("Language is " + language);

        System.out.println("@@@ Spring Bean 1 SPEL Injection " +  beanStringInjection + " @@@");


    }

    //Q5 - Runs before the application context shuts down.
    @PreDestroy
    public void preDestroy(){
        System.out.println("Spring Bean 1 PreDestroy");
    }

    //Q5 - Runs before the application context shuts down, runs after PreDestroy.
    //     This comes from implementing DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Bean 1 Destroy Method");

    }
}
