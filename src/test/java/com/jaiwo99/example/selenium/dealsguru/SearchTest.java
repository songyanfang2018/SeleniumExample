package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends AbstractSeleniumTests {

    @Test
    public void homePageWorks() {
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
        assertThat(cards.size()).isGreaterThan(0);
    }

    @Test
    public void searchForBeliebtWorks() {
        final WebElement beliebtButton = driver.findElement(By.linkText("Beliebt"));
        beliebtButton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);
    }

    @Ignore
    @Test
    public void searchForKeywordWorks() {
        final WebElement searchField = driver.findElement(By.cssSelector(".search input"));
        searchField.sendKeys("handy");
        final WebElement searchButton = driver.findElement(By.cssSelector(".magic"));
        searchButton.click();
    }
}
