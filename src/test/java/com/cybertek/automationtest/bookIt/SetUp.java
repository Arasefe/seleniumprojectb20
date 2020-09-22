package com.cybertek.automationtest.bookIt;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class SetUp {
    WebDriver driver;
    public  void main(String[] args) {
        WebDriverFactory.getDriver("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();


    }

}
