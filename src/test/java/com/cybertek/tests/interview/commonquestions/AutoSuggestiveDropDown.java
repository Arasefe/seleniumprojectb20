package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestiveDropDown {


        public static void main (String[]args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.ksrtc.in");
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

            System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());

            //Javascript DOM can extract hidden elements
            //because selenium cannot identify hidden elements - (Ajax implementation)
            //investigate the properties of object if it have any hidden text

            //JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            String script = "return document.getElementById(\"fromPlaceName\").value;";
            String text = (String) js.executeScript(script);
            System.out.println(text);
            int i = 0;

            while (!text.equalsIgnoreCase("BENGALURU INTATION AIPORT")) {
                i++;
                driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

                text = (String) js.executeScript(script);
                System.out.println(text);
                if (i > 10) {
                    break;
                }

            }

            if (i > 10) {
                System.out.println("Element not found");
            } else {
                System.out.println("Element  found");
            }

        }


        public static void thyAutoSuggestiveDropDown(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait=new WebDriverWait(driver,15);

            driver.get("https://www.turkishairlines.com/en-us/flights/booking/");
            WebElement input=driver.findElement(By.xpath("//input[@id='portInputFrom']"));
            input.clear();
            input.sendKeys("IS");

            driver.findElement(By.xpath("//input[@id='portInputFrom']")).sendKeys(Keys.DOWN);

            System.out.println(driver.findElement(By.xpath("//input[@id='portInputFrom']")).getText());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "return document.getElementById(\"portInputFrom\").value;";
            String text = (String) js.executeScript(script);
            System.out.println(text);
            int i = 0;

            while (!text.equalsIgnoreCase("ISPARTA SULEYMAN DEMIREL AIRPORT")) {
                i++;
                driver.findElement(By.xpath("//input[@id='portInputFrom']")).sendKeys(Keys.DOWN);
                text = (String) js.executeScript(script);
                System.out.println(text);
                if (i > 10) {
                    break;
                }
            }

            if (i > 10) {
                System.out.println("Element not found");
            } else {
                System.out.println("Element  found");
            }
        }
    }

