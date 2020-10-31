package com.cybertek.tests.day12_JsExecutor_POM;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practice3 {
    @Test
    public void javaScriptExecutor_Scrolling_Infinite(){
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");
        Driver.getDriver().manage().window().maximize();

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.wait(2);

        for (int i = 0; i < 10; i++) {
            BrowserUtils.wait(1);
            js.executeScript("window.scrollBy(0,300)");
        }

        for (int i = 0; i < 5; i++) {
            BrowserUtils.wait(1);
            js.executeScript("window.scrollBy(0,1000)");
        }

        Driver.closeDriver();

    }
}
