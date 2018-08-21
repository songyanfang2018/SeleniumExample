package song.selenium.catchtestwork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.test.general.GenerateData;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)

public class HomepageTest extends AbstractSeleniumTest {

    private int index;

    public HomepageTest(int index) {
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


    public class RegistrationForm {

        WebDriver driver;
        GenerateData genData;

        @Before
        public void before(){
            driver=new ChromeDriver();
            genData=new GenerateData();
        }


    @Test
    public void weitereProdukteTest(){
        final List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
        if (index >= cards.size()) {
            return;
        }
         final WebElement card = cards.get(index);
        card.click();
        final WebElement buyButton = driver.findElement(By.cssSelector(".buy-button"));
        wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        buyButton.click();




    }

}
