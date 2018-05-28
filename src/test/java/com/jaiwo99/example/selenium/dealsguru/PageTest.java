package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PageTest extends AbstractSeleniumTests {

    @Test
    public void GoToEbayPageWorks() {
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));

        cards.forEach(card -> {
            card.click();
            final WebElement buyButton = driver.findElement(By.cssSelector(".buy-button"));
            wait.until(ExpectedConditions.elementToBeClickable(buyButton));
            buyButton.click();

            final List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(browserTabs.get(1));

            assertThat(driver.getCurrentUrl()).startsWith("https://www.ebay.de");
            driver.close();
            driver.switchTo().window(browserTabs.get(0));
        });
    }
}
