package com.cybertek.tests.day12_JsExecutor_POM;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practice2 {

    @Test
    public void javaScriptExecutor_scrolling(){
        //Get the page to scroll
        Driver.getDriver().get("http://practice.cybertekschool.com");
        Driver.getDriver().manage().window().maximize();
        //Create instance of JSExecutor and cast our driver type to it.
        WebElement link=Driver.getDriver().findElement(By.xpath("//a[.='Cybertek School']"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(3);
        //Home
        WebElement home=Driver.getDriver().findElement(By.linkText("Home"));
        js.executeScript("arguments[0].scrollIntoView(true)",home);
        BrowserUtils.wait(2);
        Assert.assertTrue(home.isDisplayed(),"Home is not displayed!!!");

        Driver.closeDriver();

    }

}
