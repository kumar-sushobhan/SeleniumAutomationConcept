package com.selenium.googleFactory;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {
    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    void searchTest(String language, String keyword) {
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultCount();
        System.out.println("Result count: " + resultCount);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "design pattern"},
                {"SA", "docker"}
        };
    }
}
