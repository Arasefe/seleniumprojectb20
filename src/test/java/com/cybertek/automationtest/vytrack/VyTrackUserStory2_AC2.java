package com.cybertek.automationtest.vytrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackUserStory2_AC2 {


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
         Given the driver on “Vehicle Costs” page.
         When the driver clicks on “Create Vehicle Costs" button
         Then the driver should be able to see “Vehicle Costs" page and dropdowns
         When the driver fills out all needed information and clicks on “Save and Close” button
         Then driver should be able to create new Vehicle Costs.
        */
        //Fleet
        WebElement fleet=driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/a/span"));
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        fleet.click();

        // Given the driver on “Vehicle Costs” page.
        WebElement vehicleCosts=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[5]/a/span"));
        Thread.sleep(2000);
        vehicleCosts.click();
        //When the driver clicks on “Create Vehicle Costs" button
        WebElement createVehicleCosts=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[2]/a"));
        Thread.sleep(2000);
        // Then the driver should be able to see “Vehicle Costs" page and dropdowns
        // When the driver fills out all needed information and clicks on “Save and Close” button

        WebElement type= driver.findElement(By.xpath("//div[@id='s2id_custom_entity_type_Type-uid-5f6673620469a']"));
        type.click();
        //Click Cost
        WebElement totalPrice=driver.findElement(By.xpath("//input[@id='custom_entity_type_TotalPrice-uid-5f667362048f1']"));
        totalPrice.sendKeys("1200");
        // Choose Date
        WebElement date=driver.findElement(By.xpath("//input[@id='date_selector_custom_entity_type_Date-uid-5f667362049a7']"));
        date.click();
        // //*[.='Today']
        //Choose Month
        Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        month.selectByValue("9");
        //Choose Year
        Select year = new Select(driver.findElement(By.xpath("driver.findElement(By.xpath(\"//input[@class='ui-datepicker-year']")));
        year.selectByValue("2018");
        // Choose day
        Select day = new Select(driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[text()='6']")));
        day.selectByVisibleText("6");
        driver.findElement(By.xpath("//textarea[@name='custom_entity_type[CostDescriptions]']")).sendKeys("Brief description");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        // Then driver should be able to create new Vehicle Costs.

        driver.findElement(By.xpath("//tr[@class='grid-header-row']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //div[@class='pull-left']

        WebElement saveAndClose=driver.findElement(By.xpath("//*[@id=\"custom_entity_type-uid-5f692bdd8c1b4\"]/div[1]/div/div/div[2]/div[1]/div[2]/div/button"));
        saveAndClose.click();



        String expectedResult="Item#";
        String actualResult=driver.findElement(By.xpath("//div[@class='pull-left']")).getText();

        Assert.assertTrue(expectedResult.contains(actualResult));


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}

