package com.cybertek.tests.day3_cssSelectorAndXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Z4_ {
    public static void main(String[] args) {
        //TC #4: Zero Bank login title verification
        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Enter username: username
        // 4.Enter password: password
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        // 5.Click to “Account Activity” link
        // 6.Verify title changed to:Expected: “Zero –Account Activity”



        // 7.Click to “Transfer Funds” link
        // 8.Verify title changed to:Expected: “Zero –Transfer Funds”
        // 9.Click to “Pay Bills” link
        // 10.Verify title changed to:Expected: “Zero -Pay Bills”
        // 11.Click to “My Money Map” link
        // 12.Verify title changed to:Expected: “Zero –My Money Map”
        // 13.Click to “Online Statements” link
        // 14.Verify title changed to:Expected: “Zero –Online Statements”

    }
}
