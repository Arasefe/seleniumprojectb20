package com.cybertek.tests.day00_SoftSkills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrack {
    public static void main(String[] args) throws InterruptedException {
        // 1 Set up the web driver
        WebDriverManager.chromedriver().setup();
        // 2 Create the instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        // 3 test if driver is working
        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user164");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        driver.close();

    }
}
