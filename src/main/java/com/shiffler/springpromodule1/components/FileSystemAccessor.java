package com.shiffler.springpromodule1.components;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("fileaccess")
public class FileSystemAccessor implements InformationAccessor{

    @Override
    public void accessorIdentification() {
        System.out.println("I'm a filesystem accessor");

    }
}
