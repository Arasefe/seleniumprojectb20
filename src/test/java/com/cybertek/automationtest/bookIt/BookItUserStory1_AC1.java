package com.cybertek.automationtest.bookIt;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookItUserStory1_AC1  {
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
    public void loginBookIt5() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement name=driver.findElement(By.xpath("//*[@id='prependedInput']"));
        name.sendKeys("teachervasctoforstall@gmail.com");
        Thread.sleep(1000);
        WebElement passWord=driver.findElement(By.xpath("//*[@id='prependedInput2']"));
        passWord.sendKeys("scottforstall");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='_submit']")).click();
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