package com.cybertek.tests.day6_dropdowns_Javafaker.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//TC #3: Selecting date on dropdown and verifying




public class P3_SelectingDate {
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
    public void selectDate(){
        // 3. Select “December 1 , 1921” and verify it is selected.
        // Select year using Select month using Select day using visible text : value attribute : index number
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1921");
        String actualYear=year.getFirstSelectedOption().getText();
        String expectedYear="1921";
        Assert.assertEquals(actualYear,expectedYear,"Year does not match...FAILED!!!");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");
        String actualMonth=month.getFirstSelectedOption().getText();
        String expectedMonth="December";
        Assert.assertEquals(actualMonth,expectedMonth,"Month does not match...FAILED!!!");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        Select day=new Select(driver.findElement(By.id("day")));
        day.selectByIndex(0);
        String actualDay=day.getFirstSelectedOption().getText();
        String expectedDay="1";
        Assert.assertEquals(actualDay,expectedDay,"Day does not match...FAILED!!!");


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }


}
