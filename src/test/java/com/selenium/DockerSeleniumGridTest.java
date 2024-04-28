package com.selenium;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DockerSeleniumGridTest {
    public WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    void setUp(String browserType) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (browserType.toLowerCase().trim()) {
            case "chrome":
                desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
                System.out.println("TEST EXECUTION STARTED ON CHROME");
                break;
            case "browser":
                desiredCapabilities.setBrowserName(Browser.FIREFOX.browserName());
                System.out.println("TEST EXECUTION STARTED ON FIREFOX");
                break;
            default:
                System.out.println("Please pass the right browser... " + browserType);
                throw new RuntimeException("Please pass the right browser... " + browserType);
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), desiredCapabilities);
    }

    @Test
    void chromeBrowserTest(){
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(8));
    }

    @Test
    void firefoxBrowserTest(){
        driver.get("https://www.linkedin.com/");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up'");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(8));
    }

    @AfterTest
    void quit(){
        System.out.println("TEST EXECUTION ENDED");
        driver.quit();
    }
}
