package ch6_Ex_Tables;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex1_Tables extends TestBase {

    @Test
    public void shouldPrintInformation(){

        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        Assert.assertTrue(rows.size() > 0);

        for (WebElement row : rows) {
            int rank = Integer.parseInt(row.findElement(By.xpath("th[1]")).getText());
            String peakName = row.findElements(By.cssSelector("td")).get(0).getText();
            String peakCountries = row.findElements(By.cssSelector("td")).get(2).getText();
            int peakHeight = Integer.parseInt(row.findElements(By.cssSelector("td")).get(3).getText());

            if (peakHeight > 4000) {
                System.out.println("Rank: "+rank + "\nPeak name: "+peakName+ "\nPeak countries: "+peakCountries+"\nPeak height: "+peakHeight);
                System.out.println("************");
            }
        }
    }
}
