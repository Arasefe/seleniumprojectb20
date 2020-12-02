package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        Actions actions=new Actions(driver);
        WebElement signIn=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        WebElement el=driver.findElement(By.xpath("//a[.='Conditions of Use']"));
        actions.doubleClick(signIn).perform();
        actions.contextClick().perform();
        actions.moveToElement(el).click();
        actions.doubleClick().perform(); actions.moveToElement(el).doubleClick().build().perform();
    }

}
