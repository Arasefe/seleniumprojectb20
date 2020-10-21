package com.cybertek.tests.day14;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VyTrackLoginTest {

    VyTrack_login vyTrack;

    @Test(description = "entering incorrect username, correct password")
    public void negativeLogin_tc30() {
        //TC#30 : Vytrack negative login test Wrong Password Test
        //1. Go to https://qa3.vytrack.com
        //2. Enter correct username
        //3. Enter incorrect password
        //4. Verify error message text is as expected Expected: “Invalid user name or password.”
        //Note: Follow Page Object Model design pattern, and get your correct credentials from configuration.properties file

        String url = ConfigurationReader.getProperty("vytrackUrl");
        Driver.getDriver().get(url);

        vyTrack = new VyTrack_login();

        vyTrack.UserNameVytrack.sendKeys(ConfigurationReader.getProperty("correctUserNameVytrack"));

        vyTrack.PasswordVytrack.sendKeys(ConfigurationReader.getProperty("incorrectPasswordVytrack"));

        vyTrack.loginButton.click();

        Assert.assertTrue(vyTrack.invalidMessage.isDisplayed(), "Message is not displayed.Verification Failed!!");

    }


    @Test(description = "driver manager login")
    public void negativeLogin_tc31() {
       /*1. Go to https://qa3.vytrack.com
        2. Enter incorrect username
        3. Enter correct password
        4. Verify error message text is as expected Expected: “Invalid user name or password.”
        Note: Follow Page Object Model design pattern, and get your correct credentials from configuration.properties file
  */
        String url = ConfigurationReader.getProperty("vytrackUrl");
        Driver.getDriver().get(url);

        vyTrack = new VyTrack_login();

        vyTrack.UserNameVytrack.sendKeys(ConfigurationReader.getProperty("incorrectUserNameVytrack"));

        vyTrack.PasswordVytrack.sendKeys(ConfigurationReader.getProperty("correctPasswordVytrack"));

        vyTrack.loginButton.click();

        Assert.assertTrue(vyTrack.invalidMessage.isDisplayed(), "Message is not displayed.Verification Failed!!");


    }

    @Test(description = "Store manager positive case")

    public void positiveLogin_32() {
    /*
    1. Go to https://qa3.vytrack.com
    2. Enter correct username
    3. Enter correct password
    4. Verify title changed Expected: “Dashboard”
    Note: Follow Page Object Model design pattern, and get your correct credentials from configuration.properties file
     */

        vyTrack = new VyTrack_login();

        vyTrack.UserNameVytrack.sendKeys(ConfigurationReader.getProperty("correctUserNameVytrack"));

        vyTrack.PasswordVytrack.sendKeys(ConfigurationReader.getProperty("incorrectPasswordVytrack"));

        vyTrack.loginButton.click();

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        String actual=Driver.getDriver().getTitle();
        String expected="Dashboard";

        Assert.assertTrue(actual.equals(expected),"Verification failed not equal");


    }


    public class VyTrack_login {

        public VyTrack_login() {
            PageFactory.initElements(Driver.getDriver(), this);

        }

        @FindBy(id = "prependedInput")
        public WebElement UserNameVytrack;

        @FindBy(id = "prependedInput2")
        public WebElement PasswordVytrack;

        @FindBy(id = "_submit")
        public WebElement loginButton;

        @FindBy(xpath = "//div[@class='alert alert-error']")
        public WebElement invalidMessage;

        @FindBy(id = "_submit")
        public WebElement forgotPassword;

    }
}
