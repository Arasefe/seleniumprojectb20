package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocator {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));

        
    }


}
