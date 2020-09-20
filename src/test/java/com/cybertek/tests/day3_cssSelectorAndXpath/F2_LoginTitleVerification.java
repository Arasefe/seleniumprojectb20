package com.cybertek.tests.day3_cssSelectorAndXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #2: Facebook incorrect login title verification
1.Open Chrome browser
2.Go to https://www.facebook.com
3.Enter incorrect username
4.Enter incorrect password
5.Verify title changed to: Expected: “Log into Facebook | Facebook”
 */
public class F2_LoginTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("lan@gotmusun.sen");
        driver.findElement(By.id("pass")).sendKeys("YuruLan");
        driver.findElement(By.name("longin")).click();
        String expectedTitle="Log into Facebook | Facebook";
        Thread.sleep(5000);
        String actualTitle=driver.getTitle();
        System.out.println("Expected Title is "+expectedTitle);
        System.out.println("Actual Title is "+actualTitle);
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Page Title verification PASSED!");
        }else{
            System.out.println("Page Title verification FAILED!!!");
        }
        driver.close();
    }
}
