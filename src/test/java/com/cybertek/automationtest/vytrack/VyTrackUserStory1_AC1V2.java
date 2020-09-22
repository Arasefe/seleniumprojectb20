package com.cybertek.automationtest.vytrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackUserStory1_AC1V2 {
    /*
    B204-140 User Story for Vytrack:
    Andrea's (B204-198 Manual TC & B204-199 Automated TC)
AC# 1 As a store manager I should NOT be able to access Vehicle Odometer page
Given As a store manager I am on the Vy-Track home page
When I click Fleet dropdown menu (module)
And when I click vehicle odometer option
I should NOT be able to see Vehicle odometer page
     */
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //1- Go to google
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void test1() {
        WebElement usernameBx=driver.findElement(By.id("prependedInput"));
        usernameBx.sendKeys("storemanager204");
        WebElement passwordBx=driver.findElement(By.id("prependedInput2"));
        passwordBx.sendKeys("UserUser123"+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        String expectedTitle="Dashboard";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        Actions actions=new Actions(driver);
        WebElement fleetMod=driver.findElement(By.linkText("Fleet"));
        actions.moveToElement(fleetMod).perform(); //hover over "Fleet" module
        WebElement vehicleOdometer=driver.findElement(By.linkText("Vehicle Odometer"));
        Assert.assertTrue(vehicleOdometer.isDisplayed());
        vehicleOdometer.click();
        String expectedMsg="You do not have permission to perform this action.";
        String actualMsg=driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).getText();
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        driver.close();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


}
