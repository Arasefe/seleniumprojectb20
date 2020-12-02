package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToEnterTextWithOutSendKeys {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");

        // 1. To initialize js object
        JavascriptExecutor JS = (JavascriptExecutor)driver;
        // 2. Use executeScript() method to enter username
        JS.executeScript("document.getElementById('twotabsearchtextbox').value='macbook pro'");
        // 3. Use executeScript() to enter password
        JS.executeScript("document.getElementById('Pass').value='tester'");
    }
}
