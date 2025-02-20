package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.browserstack.PercySDK;

import java.util.concurrent.TimeUnit;

class PrincessCruisesDemo {

    WebDriver driver;
    ChromeOptions options;

    @BeforeTest
    public void setup() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void princessCruisesDemoTest() {
        try {
            driver.get("https://www.princess.com/en-int");
            driver.manage().window().setSize(new Dimension(1920, 974));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            PercySDK.screenshot(driver, "Cookies");
            driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
            PercySDK.screenshot(driver, "Home Page");
            driver.findElement(By.xpath("//a[@data-track-id='plan-a-cruise']")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[@data-track-id='find-cruises']")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            PercySDK.screenshot(driver, "List of Cruises");
            driver.findElement(By.xpath("//button[@data-filter-id='L']")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[@id='filters-tabs-view-results']")).click();
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }


    }

}