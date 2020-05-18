package com.shiffler.springpromodule1;

import com.shiffler.springpromodule1.components.PrototypeScopeBean;
import com.shiffler.springpromodule1.components.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {

        //Q4 Create a new application context
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //Q7 This is the preferred way to make sure the context once code is done executing
        context.registerShutdownHook();

       //Q22,23 - This is how we set any profiles we want to activate.
       //Note that Beans marked with profiles not mentioned here will not show up in the Bean definition list.
       //Any Bean without a profile is included as long as it is picked up in a scan.
       context.getEnvironment().setActiveProfiles("databaseaccess");
       context.register(TopLevelConfig.class);
       context.refresh();

       //Print out the names of all of the Beans Definitions. SpringBean3 should not be visible since its exlcuded
        //from the ComponentScan
        System.out.println("\n&&&&& Bean Definitions &&&&&&");
       Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("\n&&&&& End of Bean Definitions &&&&&&\n");


        System.out.println("\n&&&&& Beans &&&&&&");
        Arrays.stream(context.getBeanNamesForType(Object.class)).forEach(System.out::println);
        System.out.println("\n&&&&& End of Beans &&&&&&\n");

       //SpringBean1 is using prototype scope so everytime we fetch a bean a new one will be created.
       //Since SpringBean1 is prototype scope it is loaded Lazily (only when needed)
       //SpringBean2 uses singleton scope so we'll get the same bean each time.
       //Since SpringBean1 is  scope it is loaded Lazily (only when needed)

        IntStream.range(0,3).forEach(x -> {
            PrototypeScopeBean prototypeScopeBean = context.getBean(PrototypeScopeBean.class);
            System.out.println(prototypeScopeBean);
        });

        IntStream.range(0,3).forEach(x -> {
            SpringBean1 springBean1 = context.getBean(SpringBean1.class);
            System.out.println(springBean1);
        });

        //Q7 we can close the context directly like this but if there is an exception
        //it may not get executed.
        context.close();

    }
}
