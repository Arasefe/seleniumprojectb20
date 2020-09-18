package com.cybertek.tests.day4_checkboxes_radio.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_XPath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // Home tagName.classValue
//        WebElement home=driver.findElement(By.xpath("//a[@class='nav-link']"));         // Relative xpath
//        driver.findElement(By.xpath("/html/body/nav/ul/li/a"));                         // Developer Tool
//        if(home.isDisplayed()){
//            System.out.println("Home is displayed...");
//        }
        // Forgot Password
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));                    // Developer Tool
        WebElement forgotPassword=driver.findElement(By.xpath("//div[@id='content' > h2]"));
        if(forgotPassword.isDisplayed()){
            System.out.println("ForgotPassword is displayed");
        }
        // E-mail
        driver.findElement(By.xpath("//input[@name='email']"));                         // Developer Tool
        WebElement email1=driver.findElement(By.xpath("//input[@type='text']"));        // Relative xpath
        email1.sendKeys("ismail_yildirim@yahoo.com");
        if(email1.isDisplayed()){
            System.out.println("Email is displayed");
        }

        // Retrieve password
        WebElement retrievePassword=driver.findElement(By.xpath("//button[@id='form_submit']"));   // Relative xpath
        if(retrievePassword.isDisplayed()){
            System.out.println("RetrievePassword is displayed...");
        }
        driver.findElement(By.xpath("//button[@class='radius']"));                      // Relative xpath
        driver.findElement(By.xpath("//button[@type='submit']"));                       // Relative xpath
        // Powered by Cybertek school
        driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div"));               // Developer Tool
        WebElement power=driver.findElement(By.xpath("//div[@style='text-align: center;']"));            // Relative xpath
        if(power.isDisplayed()){
            System.out.println("Powered by Cybertek school is displayed");
        }
        driver.close();
    }
}
