package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CategorySearchTest extends AbstractSeleniumTests {

    private int index;


    public CategorySearchTest(int index) {
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
    public void categoryWork() {
        System.out.println("Testing index: " + index);
        final WebElement largeBannerButton = driver.findElement(By.cssSelector(".large-banner"));
        largeBannerButton.click();

        final List<WebElement> categoryList = driver.findElements(By.cssSelector(".nav-item"));
        if (index >= categoryList.size()) {
            return;
        }

        final WebElement category = categoryList.get(index);
        category.click();
        final List<WebElement> subCategoryList =driver.findElements(By.cssSelector(".nav-link"));
        if (index >= subCategoryList.size()) {
            return;
        }

        final WebElement subcategory =categoryList.get(index);
        subcategory.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));

        if (cards.size() <= 0) {
            System.out.println("ERROR: Category " + category.findElement(By.cssSelector(".category-name")).getText() + " has no item");
        }

        assertThat(cards.size()).isGreaterThan(0);
    }
}
