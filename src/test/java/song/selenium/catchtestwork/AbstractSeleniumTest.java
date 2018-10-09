package song.selenium.catchtestwork;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractSeleniumTest {

    protected String baseUrl;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ScreenshotHelper screenshotHelper;

    @Before
    public void openBrowser() {
        baseUrl = "https://catch.app/";
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
