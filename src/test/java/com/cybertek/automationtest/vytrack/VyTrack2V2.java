package com.cybertek.automationtest.vytrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrack2V2 {
    /**
     * AC#7: As a truck driver I should be able to add Event.
     * Given I am on "General information” page of the any needed Vehicle Cost
     * When driver click on anywhere on the page under Type button
     * And driver able to see "Add Event" button on the upper right of the page
     * And  I click on "Add Event" button
     * Then I should be able to see empty check boxes I need to fill with car informations
     * Description, color, title, etc..
     * And I add all needed event information
     * And click on "SAVE" button
     * Then I should be able to see that event on "Activity" tab and on "General information" page as well
     */
    WebDriver driver;
    @BeforeMethod
    public void setUpDriver(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void VehicleCostAc7() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("user164");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement fleet=driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/a/span"));
        fleet.click();
        WebElement vehicleCosts=driver.findElement(By.xpath("//span[.='Vehicle Costs']"));
        vehicleCosts.click();
        Thread.sleep(5000);
        WebElement typeBody=driver.findElement(By.xpath("//tbody[@class='grid-body']"));
        Thread.sleep(5000);
        typeBody.click();
        WebElement addEvent=driver.findElement(By.xpath("//i[.='Add Event']"));
        Thread.sleep(5000);
        addEvent.click();
        WebElement title=driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        title.sendKeys("Honda");
        Thread.sleep(5000);
        WebElement saveEvent=driver.findElement(By.xpath("//button[.='Save']"));
        saveEvent.click();
        WebElement activityTab=driver.findElement(By.xpath("//div[@class='btn filter-select filter-criteria-selector filter-default-value']"));
        Assert.assertTrue(activityTab.isDisplayed(),"Activity tab is not displayed.Verification FAILED!!");
    }

}
