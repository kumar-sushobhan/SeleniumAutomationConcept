package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

@Listeners(MyTestNGListener.class)
public class GoogleTest {
    WebDriver driver;
    @Test
    void test() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        ((JavascriptExecutor)driver).executeScript("document.getElementById('APjFqb').value='selenium'");
        System.out.println("google test");
        driver.quit();
    }

    @Test
    void test1() {
        System.out.println("test 1");
    }

    @Test
    void test2() {
        System.out.println("test 2");
    }

    @Test(retryAnalyzer = com.selenium.MyRetryAnalyzer.class)
    void test3() {
        System.out.println("test 3");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Assert.assertEquals(2, 3);
    }
}
