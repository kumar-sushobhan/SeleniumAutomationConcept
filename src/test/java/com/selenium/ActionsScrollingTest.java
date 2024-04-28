package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsScrollingTest {
    WebDriver driver;
    @BeforeTest
    void startDriver(){
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    void test1() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.COMMAND).sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.COMMAND).sendKeys(Keys.HOME).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.COMMAND).sendKeys(Keys.END).perform();
        Thread.sleep(1000);

        actions.scrollToElement(driver.findElement(By.xpath("//a[text()='Delivery Information']")))
                .click(driver.findElement(By.xpath("//a[text()='Delivery Information']")))
                .perform();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//div/h1[text()='Delivery Information']")).getText(), "Delivery Information");


    }

    @Test
    void sendKeysWithPauseTest(){
        // navigate to registration page
        Actions actions = new Actions(driver);
       // driver.findElement(By.xpath("//ul/a[@href = 'https://naveenautomationlabs.com/opencart/index.php?route=account/account']")).click();
       // driver.findElement(By.xpath("//a[@href = 'https://naveenautomationlabs.com/opencart/index.php?route=account/register']")).click();
        WebElement search = driver.findElement(By.name("search"));
        String value = "macbook";
        char[] valueCharArray = value.toCharArray();
        for (char c: valueCharArray){
            actions.sendKeys(search, String.valueOf(c)).pause(Duration.ofSeconds(2)).perform();
        }
    }

    @AfterTest
    void quit() {
        if (driver !=null)
            driver.quit();
    }
}
