package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_HeaderVerification {
    public static void main(String[] args) {
        // TC #6: Zero Bankheader verification
        WebDriverManager.chromedriver().setup();
        // open browser
        WebDriver driver=new ChromeDriver();

        // 1.Open Chrome browser
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Verify header textExpected: “Log in to ZeroBank”
        String expectedText="Log in to ZeroBank";
        String actualText=driver.findElement(By.name("h3")).getText();
        
        if(actualText.equals(expectedText)){
            System.out.println("Header verification PASSED!");
        }else{
            System.out.println("Header verification FAILED!");
        }

    }
}
