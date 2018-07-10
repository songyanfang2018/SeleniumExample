package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PreisFilterWorkTest extends AbstractSeleniumTests {
    @Test
    final public void preisFilterWorkTest() throws Exception {
        driver.get(baseUrl);
        final WebElement largeBannerButton = driver.findElement(By.cssSelector(".large-banner"));
        largeBannerButton.click();


        final List<Range> ranges = Arrays.asList(
                new Range(1, 5),
                new Range(5, 10),
                new Range(10, 15),
                new Range(15, 20)
        );

        final List<WebElement> categories = driver.findElements(By.cssSelector("li.nav-item a"));

        final List<String> urls = categories.stream().map(we -> we.getAttribute("href")).collect(Collectors.toList());

        final Set<String> result = new HashSet<>();

        for (String url : urls) {
            for (Range range : ranges) {
                final String testUrl = url + "?upper=" + range.upper + "&under=" + range.under;
                System.out.println("Opening url:" + testUrl);
                driver.get(testUrl);

                final List<WebElement> itemPrice = driver.findElements(By.cssSelector(".item-price"));

                if (itemPrice.isEmpty()) {
                    continue;
                }

                for (WebElement ip : itemPrice) {
                    final String priceString = ip.getText();
                    final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));

//                    assertThat(parsedPrice.floatValue()).isLessThanOrEqualTo(range.under);
//                    assertThat(parsedPrice.floatValue()).isGreaterThanOrEqualTo(range.upper);

                    if (parsedPrice.floatValue() > range.under || parsedPrice.floatValue() < range.upper) {
                        result.add(testUrl);
                    }
                }

//                final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));

//                wait.until(ExpectedConditions.visibilityOfAllElements(cards));

//                if (cards.isEmpty()) {
//                    continue;
//                }
//
//                cards.forEach(c -> {
//                    System.out.println(c.findElement(By.cssSelector(".item-price")).getText());
//                });
//
//
//                WebElement webElement = cards.get(0).findElement(By.cssSelector(".item-price"));
//                final String priceString = webElement.getText();
//                final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));
//                assertThat(parsedPrice.floatValue()).isLessThan(range.under);
//                assertThat(parsedPrice.floatValue()).isGreaterThan(range.upper);

//                for (WebElement card : cards) {
//                    WebElement webElement = card.findElement(By.cssSelector(".item-price"));
//                    final String priceString = webElement.getText();
//                    final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));
//                    assertThat(parsedPrice.floatValue()).isLessThan(range.under);
//                    assertThat(parsedPrice.floatValue()).isGreaterThan(range.upper);
//                }

            }
        }

        result.forEach(url -> {
            System.err.println("ERROR on: " + url);
        });


//        driver.get(baseUrl + "/?upper=1&under=5&search=");
//
//        // get all cards
//
//        // loop on cards and check each price is under 5 euros
//        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
//
//        for (WebElement card : cards) {
//            WebElement webElement = card.findElement(By.cssSelector(".item-price"));
//            final String priceString = webElement.getText();
//            final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));
//            assertThat(parsedPrice.floatValue()).isLessThan(5);
//        }

    }

    public static class Range {
        public int upper;
        public int under;

        public Range(int upper, int under) {
            this.upper = upper;
            this.under = under;
        }
    }
}
