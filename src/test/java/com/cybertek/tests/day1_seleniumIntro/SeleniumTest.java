package com.cybertek.tests.day1_seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        // 1 Set up the web driver
        WebDriverManager.chromedriver().setup();
        // 2 Create the instance of the chrome driver
        WebDriver driver=new ChromeDriver();
        // 3 test if driver is working
        driver.get("https://www.google.com");

        System.out.println("The title of the page is "+driver.getTitle());
        String actualTitle=driver.getTitle();
        System.out.println("Actual title of the page is: "+actualTitle);
        String actualURL=driver.getCurrentUrl();
        System.out.println("Actual URL is: "+actualURL);
        //System.out.println("actualURL = " + actualURL);  actualURL.soutv

        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().to("https://www.facebook.com");
        System.out.println("Source Page is "+ driver.getPageSource());



    }
}
