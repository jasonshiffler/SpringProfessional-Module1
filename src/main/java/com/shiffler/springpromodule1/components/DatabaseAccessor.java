package com.shiffler.springpromodule1.components;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("databaseaccess")
public class DatabaseAccessor implements InformationAccessor {
    @Override
    public void accessorIdentification() {
        System.out.println("Im a database accessor");

    }
}
