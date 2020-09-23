package com.cybertek.automationtest.bookIt;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookItUserStory1_AC2  {
    /*
    As a user, I should be able to login in Bookit login page.
    Acceptance Criteria :
    1. Verify that the user can log in with valid credentials.
     */
    WebDriver driver;
    @BeforeMethod
    public void setUpDriver(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void loginBookIt1() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sdarben7g@alibaba.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("angiecoatham");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        String expectedResult="bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
