package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        Alert alert= driver.switchTo().alert();
        // For Information alert
        alert.accept();
        // For Confirmation alert
        alert.dismiss();
        // For Prompt alert
        alert.sendKeys("This is prompt alert");
    }
}
