package com.cybertek.automationtest.vytrack;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackUserStory2_AC2 {


    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("https://qa2.vytrack.com/user/login");
    }


    @Test
    public void vyTrackVehicleOdometer() throws InterruptedException {
        WebElement userNameInput = driver.findElement(By.name("_username"));
        userNameInput.sendKeys("user165");
        WebElement passwordInput = driver.findElement(By.name("_password"));
        passwordInput.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         /*
        Given the driver on VyTrack application home page (Quick Launchpad).
        When hover over fleet module
        And the driver clicks on “Vehicle Odometer” in drop down menu
        Then the driver should be able to see “Vehicles Odometers” page with vehicle odometer information on the grid
        */


        //1- Setup the driver
        WebDriverManager.chromedriver().setup();
        //System.setProperty("driver.type","path to the driver");
        //System.setProperty("webdriver.chrome.driver","path to the driver");

        //2- Create instance of the driver
        WebDriver driver = new ChromeDriver(); //THIS LINE IS OPENING ME BROWSER

        driver.manage().window().maximize();


        //3- Use the driver instance to test selenium
        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user164");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Given the driver on “Vehicle Costs” page.
        // When the driver clicks on “Create Vehicle Costs" button
        driver.findElement(By.xpath("//*[text()='Vehicle Costs']")).click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@title='Create Vehicle Costs']")).click();
        // Then the driver should be able to see “Vehicle Costs" page and dropdowns
        // When the driver fills out all needed information and clicks on “Save and Close” button
        // Click the type from the drop downs
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='select2-container select2 oro-select2']")).click();

        // Click Depreciation and Interests
        driver.findElement(By.xpath("//div[@id='s2id_custom_entity_type_Type-uid-5f6673620469a']")).click();

        //Click Cost
        driver.findElement(By.xpath("//input[@id='custom_entity_type_TotalPrice-uid-5f667362048f1']")).sendKeys("1234");

        // Choose Date
        driver.findElement(By.xpath("//input[@id='date_selector_custom_entity_type_Date-uid-5f667362049a7']")).click();


        //Choose Month
        Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        month.selectByValue("9");

        //Choose Year

        Select year = new Select(driver.findElement(By.xpath("driver.findElement(By.xpath(\"//input[@class='ui-datepicker-year']")));
        year.selectByValue("2018");

        // Choose day

        Select day = new Select(driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[text()='6']")));
        day.selectByVisibleText("6");


        driver.findElement(By.xpath("//textarea[@name='custom_entity_type[CostDescriptions]']")).sendKeys("Brief description");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        // Then driver should be able to create new Vehicle Costs.



    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}

