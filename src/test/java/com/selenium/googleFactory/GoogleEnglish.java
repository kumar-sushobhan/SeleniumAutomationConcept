package com.selenium.googleFactory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleEnglish extends GooglePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(name = "btnK")
    private WebElement searchBtn;
    @FindBy(name = "q")
    private WebElement searchBox;
    @FindBy(css = "div[id*='result-stats']")
    private List<WebElement> results;

    public GoogleEnglish(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        //this.searchBox.sendKeys(keyword);
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
            this.searchBox.sendKeys(ch + "");
        }
        this.wait.until((d) -> this.searchBtn.isDisplayed());
        this.searchBtn.click();
    }

    @Override
    public int getResultCount() {
        this.wait.until((d) -> this.results.size() > 0);
        return this.results.size();
    }
}
