package com.cybertek.tests.day6_dropdowns_Javafaker.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//TC #4: Selecting value from multiple select dropdown


public class P4_SelectingValue {
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
    public void selectMultipleOptionsMethod1(){
        // 3. Select all the options from multiple select dropdown.
        // 4. Print out all selected values.
        // 5. Deselect all values.
        Select multipleSelect=new Select(driver.findElement(By.name("Languages")));
        List<WebElement> list=new ArrayList<>(multipleSelect.getOptions());
        for(int i=0;i<list.size();i++){
            multipleSelect.selectByIndex(i);
            System.out.println(multipleSelect.getAllSelectedOptions().get(i).getText());
        }

        multipleSelect.deselectAll();

        Assert.assertTrue(multipleSelect.getAllSelectedOptions().isEmpty());

    }

    public void selectMultipleOptionsMethod2() throws InterruptedException {
        // 3. Select all the options from multiple select dropdown.

        // 5. Deselect all values.

        Select multipleSelect = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> list = multipleSelect.getAllSelectedOptions();
        // Loop through the options to select all of them
        // 4. Print out all selected values.
        for (WebElement eachOption : list) {
            Thread.sleep(500);
            eachOption.click();
            System.out.println("Selected: " + eachOption.getText());
            // Asserting the option is actually selected or not
            Assert.assertTrue(eachOption.isSelected(),"The option "+eachOption.getText()+" is not selected");


        }
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

}
