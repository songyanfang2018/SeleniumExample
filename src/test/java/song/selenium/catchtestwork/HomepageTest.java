package song.selenium.catchtestwork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

       @Test
       public void WeitereProdukteTest(){
           System.out.println("Testing index: " + index);
           final List<WebElement> list = driver.findElements(By.cssSelector(".card"));
           if (index >= list.size()) {
               return;
           }
           final WebElement card = list.get(index);
           card.click();


       }
   }

