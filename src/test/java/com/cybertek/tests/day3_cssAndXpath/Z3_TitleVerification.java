package com.cybertek.tests.day3_cssAndXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Z3_TitleVerification {
    public static void main(String[] args) {
        // TC #3: Zero Bank login title verification
        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Enter username: username
        // 4.Enter password: password
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        // 5.Verify title changed to:Expected: “Zero –Account Summary”
        driver.findElement(By.name("submit")).click();

        String expectedTitle="Zero –Account Summary";
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED!!!");
        }
    }
}
