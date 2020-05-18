package com.shiffler.springpromodule1;

import com.shiffler.springpromodule1.components.SpringBean4;
import org.springframework.context.annotation.*;

//8C - In order for this to work properly basePackages needs to be configured along with the excludeFilters
//The pattern matches for exclude/include Filters match on the full packagename
@ComponentScan(
        basePackages = "com.shiffler.springpromodule1.components",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = "com.shiffler.springpromodule1.components.SpringBean3"),

                //We'll discover SpringBean4 using an @Bean annotation instead
                @ComponentScan.Filter(type = FilterType.REGEX,
                        pattern = "com.shiffler.springpromodule1.components.SpringBean4")
        })
@Configuration
@PropertySource("classpath:/application.properties")
public class TopLevelConfig {

    //Q5,Q18 - Can define init and destroy methods for a Bean.
    //The init method runs after the constructor, the destroy method runs before the context closes.
    //@Bean is normally used for third party classes.
    //babyBean is the bean name, littleBean is the Alias
    //Q19 - The default name of this bean would be springBean4 but it was overriden to be babyBean
    //Q22 - Use of @Profile annotation with @Bean to determine which Bean is injected into the context.

    @Profile("databaseaccess")
    @Bean(initMethod ="initMethod" , destroyMethod ="destroyMethod", name={"dataBaseBean", "dbBean"} )
    SpringBean4 springBean4(){
        return new SpringBean4();
    }

    @Profile("fileaccess")
    @Bean(initMethod ="initMethod" , destroyMethod ="destroyMethod", name={"fileBean", "FileBasedBean"} )
    SpringBean4 springBean4File(){
        return new SpringBean4();
    }

}




