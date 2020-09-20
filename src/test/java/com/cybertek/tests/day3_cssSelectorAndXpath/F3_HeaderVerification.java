package com.cybertek.tests.day3_cssSelectorAndXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F3_HeaderVerification {
    public static void main(String[] args) {
        // TC #3: Facebook header verification
        // 1.Open Chrome browser
        // 2.Go to https://www.facebook.com

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");

        // 3.Verify header text is as expected:
        // Expected: “Connect with friends and the world around you on Facebook.”

        String expectedHeaderText="Connect with friends and the world around you on Facebook.";
        String actualHeaderText= driver.findElement(By.className("_8eso")).getText();

        System.out.println("Expected Header Text is "+expectedHeaderText);
        System.out.println("Actual Header Text is "+actualHeaderText);
        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header  verification PASSED!");
        }else{
            System.out.println("Header verification FAILED!!!");
        }
        driver.close();


    }
}
