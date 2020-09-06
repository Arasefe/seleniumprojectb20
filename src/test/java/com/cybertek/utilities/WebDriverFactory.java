package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {
    /*
    Method name: getDriver
    static method
    Accepts String arg
    browser type will determine what browser opens
    return type WebDriver
     */
    public static void main(String[] args) {
        getDriver("ChromeDriver");


    }


    public static WebDriver getDriver(String name) {

        switch (name) {
            case "Chrome Driver":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "FireFox Driver":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "Opera Driver":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();

            case "Edge Driver":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case "InternetExplorer":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();

            default:
                System.out.println("Not valid input");
                return null;
        }

    }
}
