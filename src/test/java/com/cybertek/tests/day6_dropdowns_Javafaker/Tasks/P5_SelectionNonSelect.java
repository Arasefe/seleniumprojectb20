package com.cybertek.tests.day6_dropdowns_Javafaker.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P5_SelectionNonSelect {
    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @Test
    public void selectNonSelectMethod(){
        // 3. Click to non-select dropdown
        driver.findElement(By.id("dropdownMenuLink")).click();
        // 4. Select Facebook from dropdown
        driver.findElement(By.xpath("//*[text()='Facebook']")).click();
        // 5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle=driver.getTitle();
        String expectedTitle="Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle,expectedTitle,"The title does not match FAILED!!!");

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

}
