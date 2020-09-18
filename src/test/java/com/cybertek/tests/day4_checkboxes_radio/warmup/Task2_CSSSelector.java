package com.cybertek.tests.day4_checkboxes_radio.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_CSSSelector {
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/add_remove_elements
    // 3. Click to “Add Element” button
    // 4. Verify “Delete” button is displayed after clicking.
    // 5. Click to “Delete” button.
    // 6. Verify “Delete” button is NOT displayed after clicking.

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement addElement=driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        if(addElement.isDisplayed()){
            System.out.println("Add element is displayed");
        }

        addElement.click();
        WebElement deleteButton=driver.findElement(By.cssSelector("div[id='elements']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed...");
        }
        deleteButton.click();

        if(!deleteButton.isDisplayed()){
            System.out.println("Delete button is NOT displayed...");
        }


        driver.close();

    }

}
