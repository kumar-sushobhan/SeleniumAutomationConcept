package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderTestConcept {
    WebDriver driver;
    @Test(dataProvider = "loginTestData")
    void loginTest(String username, String password) {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[class*='orangehrm-login-button']")).click();
    }

    @DataProvider(name = "loginTestData")
    public Object[][] loginDate() {
        Object[][] data = new Object[2][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";
        data[1][0] = "Admin2";
        data[1][1] = "Admin@345";
        return data;
    }
}
