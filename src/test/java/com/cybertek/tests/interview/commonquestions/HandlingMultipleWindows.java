package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandlingMultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.qaclickacademy.com/practice.php");
        //1 Step I store all windows to a String Set

        WebElement footerDriver=driver.findElement(By.id("gf-BIG"));            // Limiting webDriver scope
        WebElement columnDriver=footerDriver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td"));

        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clinkOnLink= Keys.chord(Keys.COMMAND,Keys.ENTER);                    // Keys.CONTROL-->Windows
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clinkOnLink);
            Thread.sleep(5000);
        }
        Set<String> handles=driver.getWindowHandles();
        //2 Step I create String Iterator
        Iterator<String>it=handles.iterator();
        //3 Step I iterate through and switchTo()
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }


    }

}
