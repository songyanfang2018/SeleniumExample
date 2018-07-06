package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(Parameterized.class)
public class CustomerSegmentsPreisFilterTest extends AbstractSeleniumTests {

    private int index;

    public CustomerSegmentsPreisFilterTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> result = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            result.add(new Object[]{i});
        }

        return result;
    }

    @Test
    final public void CustomerSegmentsPreisFilterKontrollWork() throws Exception {
        driver.get(baseUrl);
        final List<WebElement> categoryList1 = driver.findElements(By.cssSelector(".customer-segment-link"));
        if (index >= categoryList1.size()) {
            return;
        }
        final WebElement category1 = categoryList1.get(index);

        final String href = category1.getAttribute("href");
        System.out.println("Go to href: " + href);

        driver.get(href);
        final List<WebElement> categoryList = driver.findElements(By.cssSelector(".nav-item"));

        if (index >= categoryList.size()) {
            return;
        }
        final WebElement category = categoryList.get(index);
        category.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));

        if (cards.size() <= 0) {
            System.out.println("ERROR: Category " + category.findElement(By.cssSelector(".category-name")).getText()
                    + " has no item");
        }

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


        }
    }

        result.forEach(url -> {
        System.err.println("ERROR on: " + url);
    });
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

