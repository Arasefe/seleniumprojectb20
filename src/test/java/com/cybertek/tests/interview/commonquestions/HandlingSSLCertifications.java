package com.cybertek.tests.interview.commonquestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLCertifications {
    public static void main(String[] args) {
        DesiredCapabilities ch=DesiredCapabilities.chrome();
        //ch.acceptInsecureCerts();
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //Belows to your local browser
        ChromeOptions c= new ChromeOptions();
        c.merge(ch);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(c);



    }
}
