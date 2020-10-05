package com.cybertek.tests.day10_testbase_properties_driverUtil;

import org.testng.annotations.Test;

public class LearningProperties {
    @Test
    public void java_properties_test(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

        // key=value
        // os.name=Mac OS X
        // user.name=banuyildirim
        // keys have to be exactly the same as value when you pass it
        // otherwise it will not work. If you are getting 'null' make sure your key is correct


    }
}
