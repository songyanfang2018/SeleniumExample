package com.jaiwo99.example.selenium.dealsguru;


import com.jaiwo99.example.selenium.dealsguru.util.ScreenshotHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractSeleniumTests {

    protected String baseUrl;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ScreenshotHelper screenshotHelper;

    @Before
    public void openBrowser() {
        baseUrl = "https://dealsguru.de";
        //baseUrl = System.getProperty("base.url");
        final ChromeOptions options = new ChromeOptions();

        // decides if running browser in headless mode
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        wait  = new WebDriverWait(driver, 10);
        screenshotHelper = new ScreenshotHelper();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
