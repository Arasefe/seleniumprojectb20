package com.cybertek.tests.day3_cssSelectorAndXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_Amazon_cssSelector {
    public static void main(String[] args) throws InterruptedException{
        // TC #3: Amazon link number verification
        // 1. Open Chrome browser
        // 2. Go to https://www.amazon.com
        // 3. Enter search term (use cssSelector to locate search box)


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        //WebElement searchBox= driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        WebElement searchBox= driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("Wooden spoon"+ Keys.ENTER);
        // 4. Verify title contains search term
        String expectedTitle="Wooden spoon";
        String actualTitle=driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
