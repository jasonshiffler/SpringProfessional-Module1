package com.shiffler.springmodule;

import com.shiffler.springpromodule1.TopLevelConfig;
import com.shiffler.springpromodule1.components.InformationAccessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


// Q6 - These are the Annotations required to bring up the context for testing.
@RunWith(SpringRunner.class)                           //This is a JUnit Annotation
@ContextConfiguration(classes = TopLevelConfig.class)  //This is the configuration we want to use for testing
@ActiveProfiles("databaseaccess")                      //Need this to make sure the beans with this profile are loaded
public class ApplicationTest {

    @Autowired
    private InformationAccessor informationAccessor;

    @Test
    public void runBean(){
        System.out.println("Testing: " + informationAccessor.toString());
    }

}
