package com.cybertek.tests.day3_cssAndXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #2: Zero Bank link text verification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Verify link text from top left:Expected: “Zero Bank”
4.Verify link href attribute value contains:Expected: “index.html”
 */
public class Z2_ZeroBankLinkVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedLinkText="Zero Bank";
        String actualLinkText=driver.findElement(By.className("brand")).getText();
        if(actualLinkText.equals(expectedLinkText)){
            System.out.println("Link text verification PASSED!");
        }else{
            System.out.println("Link text verification FAILED!!!");
        }

        String expectedLinkAttribute="index.html";
        String actualLinkAttribute=driver.findElement(By.linkText("Zero Bank")).getAttribute("href");
        if(actualLinkAttribute.equals(expectedLinkAttribute)){
            System.out.println("Link Attribute verification PASSED!");
        }else{
            System.out.println("Link Attribute verification FAILED!!!");
        }
        driver.close();
    }
}
