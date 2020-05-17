package com.shiffler.scopesample;

import com.shiffler.scopesample.components.SpringBean1;
import com.shiffler.scopesample.components.SpringBean2;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {

        //Q4 Create a new application context
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TopLevelConfig.class);

        //Q7 This is the preferred way to make sure the context once code is done executing
       context.registerShutdownHook();


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
            SpringBean1 springBean1 = context.getBean(SpringBean1.class);
            System.out.println(springBean1);
        });

        IntStream.range(0,3).forEach(x -> {
            SpringBean2 springBean2 = context.getBean(SpringBean2.class);
            System.out.println(springBean2);
        });

        //Q7 we can close the context directly like this but if there is an exception
        //it may not get executed.
        context.close();

    }
}
