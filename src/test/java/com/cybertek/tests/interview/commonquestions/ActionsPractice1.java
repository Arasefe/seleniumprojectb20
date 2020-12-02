package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        Actions actions=new Actions(driver);
        WebElement signIn=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        //actions.moveToElement(signIn).build().perform();

        actions.contextClick(signIn).build().perform();

        driver.close();
    }
}
