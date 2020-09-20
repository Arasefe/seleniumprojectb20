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


public class P2_SelectingState {
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
    public void verifyStateDropDown() {
        // 3. Select Illinois
        // Use all Select options. (visible text, value, index)

        Select selectStates = new Select(driver.findElement(By.id("state")));
        selectStates.selectByVisibleText("Illinois");
        String actualResult = selectStates.getFirstSelectedOption().getText();
        String expectedResult = "Illinois";
        Assert.assertEquals(actualResult, expectedResult, "Illinois is not visible");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 4. Select Virginia
        selectStates.selectByValue("VA");
        actualResult = selectStates.getFirstSelectedOption().getText();
        expectedResult = "Virginia";
        Assert.assertEquals(actualResult, expectedResult, "Virginia is not visible");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 5. Select California
        selectStates.selectByIndex(5);
        actualResult = selectStates.getFirstSelectedOption().getText();
        expectedResult = "California";
        // 6. Verify final selected option is California.
        Assert.assertEquals(actualResult, expectedResult, "California is not visible");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

}
