package com.jaiwo99.example.selenium.dealsguru;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends AbstractSeleniumTests {

    @Test
    public void homePageWorks() {
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
        assertThat(cards.size()).isGreaterThan(0);
    }

    @Test
    public void logoWorks(){
        final WebElement poplogoButton = driver.findElement(By.cssSelector(".logo"));
        poplogoButton.click();
        final List<WebElement> navitems = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(navitems));
        assertThat(navitems.size()).isGreaterThan(0);

    }



    @Test
    public void customerSegmentsWork(){
        final WebElement customerSegmentsButton = driver.findElement(By.cssSelector("#customer-segment-switch"));
        customerSegmentsButton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".customer-segment-name"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);
    }

    @Test
    public void customerSegmentsCategoryTest(){
        customerSegmentsbutton();


    }
    @Test
    public void customerSegmentsBeliebtWork(){
        customerSegmentsbutton();
        final WebElement beliebtbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/38/Beliebt']"));
        beliebtbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsBabyWork(){
        customerSegmentsbutton();
        final WebElement babybutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/42/Baby']"));
        babybutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsBeautyAndGesundheitWork(){
        customerSegmentsbutton();
        final WebElement beautyAndGesundheitbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/56/Beauty-Gesundheit']"));
        beautyAndGesundheitbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsHomeAndDekoWork(){
        customerSegmentsbutton();
        final WebElement homeAndDekobutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/65/Home-Deko']"));
        homeAndDekobutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsSportWork(){
        customerSegmentsbutton();
        final WebElement sportbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/71/Sport']"));
        sportbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsFashionDamenWork(){
        customerSegmentsbutton();
        final WebElement fashionDamenbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/94/Fashion-Damen']"));
        fashionDamenbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsFestivalsWork(){
        customerSegmentsbutton();
        final WebElement festivalsbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/222/Festivals']"));
        festivalsbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsSpielzeugWork(){
        customerSegmentsbutton();
        final WebElement spielzeugbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/243/Spielzeug']"));
        spielzeugbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsFotoWork(){
        customerSegmentsbutton();
        final WebElement fotobutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/249/Foto']"));
        fotobutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsHerrenmodeWork(){
        customerSegmentsbutton();
        final WebElement herrenmodebutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/254/Herrenmode']"));
        herrenmodebutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsPartyWork(){
        customerSegmentsbutton();
        final WebElement partybutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/285/Party']"));
        partybutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsHobbyAndDIYWork(){
        customerSegmentsbutton();
        final WebElement hobbyAndDIYbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/264/Hobby-DIY']"));
        hobbyAndDIYbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void customerSegmentsGadgetsWork(){
        customerSegmentsbutton();
        final WebElement gadgetsbutton = driver.findElement(By.xpath("//a[@href='/feeder/browse/270/Gadgets']"));
        gadgetsbutton.click();
        final List<WebElement> cards = driver.findElements(By.cssSelector(".nav-item"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cards));
        assertThat(cards.size()).isGreaterThan(0);

    }

    @Test
    public void searchForUnder5Euro() throws Exception {
        driver.get(baseUrl + "/?upper=1&under=5&search=");

        // get all cards

        // loop on cards and check each price is under 5 euros
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));

        for (WebElement card : cards) {
            WebElement webElement = card.findElement(By.cssSelector(".item-price"));
            final String priceString = webElement.getText();
            final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));
            assertThat(parsedPrice.floatValue()).isLessThan(5);
        }

    }

    @Test
    public void searchForUnder10Euro() throws Exception {

        driver.get(baseUrl + "/?upper=1&under=10&search=");


        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));


        for (WebElement card : cards) {
            WebElement webElement = card.findElement(By.cssSelector(".item-price"));
            final String priceString = webElement.getText();
            final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));
            assertThat(parsedPrice.floatValue()).isLessThan(10);
        }

    }

    @Test
    public void searchForUnder15Euro() throws Exception {

        driver.get(baseUrl + "/?upper=1&under=15&search=");


        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));


        for (WebElement card : cards) {
            WebElement webElement = card.findElement(By.cssSelector(".item-price"));
            final String priceString = webElement.getText();
            final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));
            assertThat(parsedPrice.floatValue()).isLessThan(15);
        }

    }


    @Test

    public void searchForUnder20Euro() throws Exception {

        driver.get(baseUrl + "/?upper=1&under=20&search=");


        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));


        for (WebElement card : cards) {
            WebElement webElement = card.findElement(By.cssSelector(".item-price"));
            final String priceString = webElement.getText();
            final Number parsedPrice = NumberFormat.getInstance(Locale.GERMANY).parse(priceString.replaceAll(" €", ""));
            assertThat(parsedPrice.floatValue()).isLessThan(20);
        }

    }

    @Test
    public void searchForKeywordWorks() {
        final WebElement searchField = driver.findElement(By.cssSelector(".search input"));
        searchField.sendKeys("handy");
        searchField.sendKeys(Keys.RETURN);
//        final WebElement searchButton = driver.findElement(By.cssSelector(".magic"));
//        searchButton.click();
    }

private  void customerSegmentsbutton(){
    final WebElement customerSegmentsButton = driver.findElement(By.cssSelector("#customer-segment-switch"));
    customerSegmentsButton.click();

}

}



