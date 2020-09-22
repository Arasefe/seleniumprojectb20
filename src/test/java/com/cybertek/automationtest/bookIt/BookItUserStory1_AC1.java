package com.cybertek.automationtest.bookIt;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookItUserStory1_AC1 extends SetUp {
    /*
    As a user, I should be able to login in Bookit login page.
    Acceptance Criteria :
    1. Verify that the user can log in with valid credentials.
     */
    @Test
    public void loginBookIt1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sdarben7g@alibaba.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("angiecoatham");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        String expectedResult="bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }
    /*
    @Test
    public void loginBookIt2() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("aneagle7h@miibeian.gov.cn");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bennetttomanek");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        String expectedResult="bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }
    @Test
    public void loginBookIt3(){
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ewrist7i@livejournal.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("marianndewi");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String actualTitle=driver.getTitle();
        String expectedResult="bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }

    @Test
    public void loginBookIt4() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jalabaster7f@drupal.org");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("terimapam");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        String expectedResult="bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));
    }


    @Test
    public void loginBookIt5() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("teachervasctoforstall@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("scottforstall");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        String expectedResult="bookit";
        Assert.assertTrue(actualTitle.equals(expectedResult));

    }







*/
}