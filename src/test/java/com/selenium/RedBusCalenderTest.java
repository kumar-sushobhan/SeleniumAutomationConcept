package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RedBusCalenderTest {
    WebDriver driver;

    @Test
    void printHolidaysAndWeekends() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.get("https://www.redbus.in");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        this.driver.findElement(By.cssSelector("#onwardCal")).click();

        // click on -> until the supplied value of month matches the user's input
        List<String> weekendDates = new WeekendDates().getWeekendDates(this.driver, "Aug 2024");
        System.out.println(weekendDates);
    }
}
