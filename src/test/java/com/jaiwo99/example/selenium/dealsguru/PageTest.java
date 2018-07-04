package com.jaiwo99.example.selenium.dealsguru;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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
import static org.assertj.core.api.Assertions.fail;

@RunWith(Parameterized.class)
public class PageTest extends AbstractSeleniumTests {

    private int index;

    public PageTest(int index) {
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
    public void GoToEbayPageWorks() {
        System.out.println("Testing index: " + index);
        final List<WebElement> list = driver.findElements(By.cssSelector(".card"));

        if (index >= list.size()) {
            return;
        }

        final WebElement card = list.get(index);
        card.click();
        final WebElement buyButton = driver.findElement(By.cssSelector(".buy-button"));
        wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        buyButton.click();

        final List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        final String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).startsWith("https://www.ebay.de");
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void FotoCheckWorks() {
        System.out.println("Testing index: " + index);
        final List<WebElement> list = driver.findElements(By.cssSelector(".card"));
        if (index >= list.size()) {
            return;
        }

        final WebElement card = list.get(index);

        card.click();
        final List<WebElement> images = driver.findElements(By.cssSelector(".mini-image"));

        if (!verifyimageActive(images.get(0))) {
            fail("Image doesn't exist, url: " + driver.getCurrentUrl());
        }
    }

    private boolean verifyimageActive(WebElement imgElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imgElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("Image: " + imgElement.getAttribute("id") + "displayed");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
