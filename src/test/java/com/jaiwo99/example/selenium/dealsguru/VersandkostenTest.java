package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.openqa.selenium.By;

import java.text.NumberFormat;
import java.util.*;
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

        for (int i = 0; i < 10; i++) {
            result.add(new Object[]{i});
        }

        return result;
    }

    @Test
    public void versandKostenFreiTest() {

        System.out.println("Testing index: " + index);

        final WebElement largeBannerButton = driver.findElement(By.cssSelector(".large-banner"));
        largeBannerButton.click();
        final WebElement filterIconButton = driver.findElement(By.cssSelector("#sticky-filter-control"));
        filterIconButton.click();
        final WebElement versandkostenButton = driver.findElement(By.xpath("//input[@id='free-shipping']"));
        versandkostenButton.click();
        final WebElement inputClassButton = driver.findElement(By.xpath("//input[@id='submit-filter']"));
        inputClassButton.click();
        final List<WebElement> list = driver.findElements(By.cssSelector(".card"));
        if (index >= list.size()) {
            return;
        }

        final WebElement card = list.get(index);

        card.click();

        final WebElement itemPrice = driver.findElement(By.xpath("//div[@class='item-info']/span[@class='big-item-info']"));


    }
}