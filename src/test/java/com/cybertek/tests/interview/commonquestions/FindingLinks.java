package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
        driver.close();


    }
}