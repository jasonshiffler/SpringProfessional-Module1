package com.shiffler.scopesample;

import com.shiffler.scopesample.components.SpringBean4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//8C - In order for this to work properly basePackages needs to be configured along with the excludeFilters
//The pattern matches for exclude/include Filters match on the full packagename
@ComponentScan(
        basePackages = "com.shiffler.scopesample.components",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = "com.shiffler.scopesample.components.SpringBean3"),
                @ComponentScan.Filter(type = FilterType.REGEX,
                        pattern = "com.shiffler.scopesample.components.SpringBean4")
        })
@Configuration
public class TopLevelConfig {

    //Q5 - Can define init and destroy methods for a Bean.
    //The init method runs after the constructor, the destroy method runs before the context closes.
    @Bean(initMethod ="initMethod" , destroyMethod ="destroyMethod" )
    SpringBean4 springBean4(){
        return new SpringBean4();
    }

}




