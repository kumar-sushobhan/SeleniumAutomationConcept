package com.selenium;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAllThePriceAndSort {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String xpath = "//*[@id='leftcontainer']/table/tbody/tr/td[4]";
        List<WebElement> prices = driver.findElements(By.xpath(xpath));
        List<Double> intPrices = new ArrayList<>();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        for (int i=1; i< prices.size();i++){
            String text = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[4]")).getText();
            intPrices.add(Double.parseDouble(text));
        }
        System.out.println(intPrices);
        driver.quit();

        List<Double> sortedPrice = intPrices.stream()
                .sorted(Comparator.comparingDouble(Double::doubleValue))
                .collect(Collectors.toList());
        System.out.println("Sorted price : " + sortedPrice);
    }
}
