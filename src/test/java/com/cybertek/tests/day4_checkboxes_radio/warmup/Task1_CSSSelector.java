package com.cybertek.tests.day4_checkboxes_radio.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_CSSSelector {
    //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/forgot_password
    //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
    //a. “Home” link
    //b. “Forgot password” header
    //c. “E-mail” text
    //d. E-mail input box
    //e. “Retrieve password” button
    //f. “Powered by Cybertek School” text
    //4. Verify all WebElements are displayed.


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // Home tagName.classValue
        if(driver.findElement(By.cssSelector("a.nav-link")).isDisplayed()){
            System.out.println("Displayed...");
        }

        // #content > div > h2


        // Forgot Password                                          // CSSSelector #content > div > h2
        //WebElement forgotPassword=driver.findElement(By.cssSelector("div[id='content']>div>h2"));
        WebElement forgotPassword=driver.findElement(By.cssSelector("div[class='example']>h2"));

        if(forgotPassword.isDisplayed()){
            System.out.println("forgotPassword is displayed");
        }
        // E-mail
        WebElement eMail1=driver.findElement(By.cssSelector("input[type='text']"));
        WebElement eMail2=driver.findElement(By.cssSelector("input[name='email']"));
        eMail1.sendKeys("ismail_yildirim@yahoo.com");
        if(eMail1.isDisplayed()){
            System.out.println("Email is displayed...");
        }

        // Retrieve password
        driver.findElement(By.cssSelector("#form_submit > i"));
        WebElement retrievePassword=driver.findElement(By.cssSelector("button#form_submit"));
        driver.findElement(By.cssSelector("button.radius"));
        driver.findElement(By.cssSelector("button[type='submit']"));
        // Powered by Cybertek school
        driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        if(retrievePassword.isDisplayed()){
            System.out.println("Retrieve password is displayed...");
        }
        //driver.close();
    }

}
