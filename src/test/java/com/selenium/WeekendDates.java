package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WeekendDates {

    public List<String> getWeekendDates(WebDriver driver, String month) throws InterruptedException {
        // get the current month
        String text = driver.findElement(By.cssSelector("div[class$='hHKFiR'] > div:nth-child(1) > div:nth-child(2)")).getText();

        List<String> weekendListString = null;
        while (!driver.findElement(By.cssSelector("div[class$='hHKFiR'] > div:nth-child(1) > div:nth-child(2)")).getText().contains(month)) {
            driver.findElement(By.cssSelector("#onwardCal")).click();
            // print the month and number of holidays
            String monthAndHoliday = driver.findElement(By.cssSelector("div[class$='hHKFiR'] > div:nth-child(1) > div:nth-child(2)")).getText();
            System.out.println(monthAndHoliday);
            Thread.sleep(2000);
            // click on > icon
            driver.findElement(By.cssSelector("div[class$='hHKFiR'] > div:nth-child(1) > div:nth-child(3) > svg")).click();
            Thread.sleep(2000);
            // find the month
            String text1 = driver.findElement(By.cssSelector("div[class$='hHKFiR'] > div:nth-child(1) > div:nth-child(2)")).getText();
            // if the desired month is present, find the weekends
            if (text1.contains(month)) {
                System.out.println(driver.findElement(By.cssSelector("div[class$='hHKFiR'] > div:nth-child(1) > div:nth-child(2)")).getText());
                // get the weekends
                List<WebElement> weekendList = driver.findElements(By.cssSelector("span[class*='bwoYtA']"));
                weekendListString = weekendList.stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
            }
        }
        driver.quit();
        return weekendListString;
    }
}
