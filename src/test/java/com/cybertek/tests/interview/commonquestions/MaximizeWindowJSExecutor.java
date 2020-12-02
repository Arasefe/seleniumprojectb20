package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MaximizeWindowJSExecutor {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();
        // if this does not work

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,900");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        driver.quit();
    }

}
