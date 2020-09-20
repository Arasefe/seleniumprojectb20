package com.cybertek.automationtest.vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VyTrackUserStory1_AC1 {
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


        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user164");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // When the driver clicks the Vehicle Odometer Page from drop down menu

        driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='title title-level-2'])[2]")).click();
        //Then the driver should be able to see “Vehicles Odometers” page with vehicle odometer information on the grid
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String expectedResult="Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualResult=driver.getTitle();
        if(actualResult.equals(expectedResult)){
            System.out.println("Title verification PASSED!!");
        }else{
            System.out.println("Title Verification FAILED!!");
        }
        driver.close();

    }
}
