package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class BuyProcessTest extends AbstractSeleniumTests{
    private int index;

    public BuyProcessTest(int index) {
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
    public void BuyWork(){
        driver.get(baseUrl);
        final WebElement largeBannerButton = driver.findElement(By.cssSelector(".large-banner"));
        largeBannerButton.click();

        final List<WebElement> list = driver.findElements(By.cssSelector("card"));


        if (index >= list.size()) {
            return;
        }

        final WebElement card = list.get(index);

        card.click();
        Select quality = new Select(driver.findElement(By.name("qty")));
        quality.selectByIndex(1);


    }
}
