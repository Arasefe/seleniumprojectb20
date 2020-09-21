package com.cybertek.automationtest.vytrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackUserStory1_AC1 {
    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("https://qa2.vytrack.com/user/login");
    }


    @Test
    public void vyTrackVehicleOdometer() throws InterruptedException {
        WebElement userNameInput = driver.findElement(By.name("_username"));
        userNameInput.sendKeys("user165");
        WebElement passwordInput = driver.findElement(By.name("_password"));
        passwordInput.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         /*
        Given the driver on VyTrack application home page (Quick Launchpad).
        When hover over fleet module
        And the driver clicks on “Vehicle Odometer” in drop down menu
        Then the driver should be able to see “Vehicles Odometers” page with vehicle odometer information on the grid
        */

        Actions action = new Actions(driver);
        //Fleet
        WebElement fleet=driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/a/span"));
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        fleet.click();

        //*[@id="main-menu"]/ul/li[1]/div/div/ul/li[4]/a/span
        WebElement vehicleOdometer=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a/span"));
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        vehicleOdometer.click();



        String expectedResult="Vehicles Odometers";
        //*[text()='Vehicles Odometers']
        String actualResult=driver.findElement(By.xpath("//*[.='Vehicles Odometers']")).getText();

        Assert.assertEquals(actualResult,expectedResult,"Actual result does not not match expected result, FAILED!!!");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}

