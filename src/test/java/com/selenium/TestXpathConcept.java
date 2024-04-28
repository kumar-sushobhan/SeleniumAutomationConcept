package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestXpathConcept {
    WebDriver driver;
    @Test
    void xpathCheck() {
        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDetailsForAGivenName("Joe.Root", driver);
    }

    // utility
    private void getDetailsForAGivenName(String name, WebDriver driver) {
        String userRolexPath = "//*[contains(text(),'"+name+"')]/parent::td/following-sibling::td[1]";
        String employeeNamexPath= "//*[contains(text(),'"+name+"')]/parent::td/following-sibling::td[2]";
        String statusxPath = "//*[contains(text(),'"+name+"')]/parent::td/following-sibling::td[3]";
        String userRole = driver.findElement(By.xpath(userRolexPath)).getText();
        String employeeName = driver.findElement(By.xpath(employeeNamexPath)).getText();
        String status = driver.findElement(By.xpath(statusxPath)).getText();
        System.out.println("User role : " + userRole);
        System.out.println("Employee name : " + employeeName);
        System.out.println("Status : " + status);
    }
}
