package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingIFrames {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/droppable/");

        WebElement iframe=driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
        driver.switchTo().frame(iframe);
        Actions actions=new Actions(driver);
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source,target).build().perform();
        driver.switchTo().defaultContent();
        driver.close();


    }
}
