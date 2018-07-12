package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)

public class VersandkostenTest extends AbstractSeleniumTests {

    private int index;

    public VersandkostenTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> result = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            result.add(new Object[]{i});
        }

        return result;
    }

    @Test
    public void versandKostenFreiTest() throws Exception {

        driver.get(baseUrl);

        final WebElement largeBannerButton = driver.findElement(By.cssSelector(".large-banner"));
        largeBannerButton.click();

        final List<WebElement> categories = driver.findElements(By.cssSelector("li.nav-item a"));


        final List<String> urls = categories.stream().map(we -> we.getAttribute("href")).collect(Collectors.toList());


        for (String url : urls) {

            final String testUrl = url + "?upper=" + 1 + "&under=" + 20 + "&free_shipping=1";
            System.out.println("Opening url:" + testUrl);
            driver.get(testUrl);

            final List<WebElement> list = driver.findElements(By.cssSelector(".card"));
            if (index >= list.size()) {
                return;
            }

            final WebElement card = list.get(index);

            card.click();

            final WebElement  = driver.findElement(By.xpath("//div[@class='mobile-header']/span[@class='big-item-info']"));

        }





    }
}