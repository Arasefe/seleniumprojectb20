package com.cybertek.automationtest.bookIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookItUserStory1_AC1 {
    public static void main(String[] args) {
        //1- Setup the driver
        WebDriverManager.chromedriver().setup();
        //System.setProperty("driver.type","path to the driver");
        //System.setProperty("webdriver.chrome.driver","path to the driver");

        //2- Create instance of the driver
        WebDriver driver = new ChromeDriver(); //THIS LINE IS OPENING ME BROWSER

        driver.manage().window().maximize();


        //3- Use the driver instance to test selenium
        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sdarben7g@alibaba.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("angiecoatham");
        driver.findElement(By.xpath("//button[@type='submit']")).click();




    }
}