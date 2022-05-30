package homework_SeleniumBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework_DataPickers extends TestBase {

    @Test
    public void shouldPickDate(){
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        driver.findElement(By.cssSelector("#datepicker")).click();

        if (getCurrentMonth() == 7){
            if (getCurrentYear() == 2022){
                getForthCell().click();
            }else if(getCurrentYear() > 2022){
                while (getCurrentYear() != 2022){
                    getPrevArrowHandler().click();
                }
                getForthCell().click();
            }else {
                while (getCurrentYear() != 2022){
                    getNextArrowHandler().click();
                }
                getForthCell().click();
            }
        }else if(getCurrentMonth() > 7){
            while (getCurrentMonth() != 7){
                getPrevArrowHandler().click();
            }
            getForthCell().click();
        }else {
            while (getCurrentMonth() != 7){
                getNextArrowHandler().click();
            }
            getForthCell().click();
        }

        System.out.println(getDataPicker());
        Assert.assertEquals(getDataPicker(),"08/31/2022");
    }


    public WebElement getNextArrowHandler(){
        return driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']"));
    }
    public WebElement getPrevArrowHandler(){
        return driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-w']"));
    }

    public int getCurrentYear(){
        return Integer.parseInt(getForthCell().getAttribute("data-year"));
    }

    public int getCurrentMonth(){
        return Integer.parseInt(getForthCell().getAttribute("data-month"));
    }

    public WebElement getForthCell(){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        WebElement fifthRow = rows.get(4);

        List<WebElement> rowCells = fifthRow.findElements(By.cssSelector("td"));
        return rowCells.get(3);
    }

    public String getDataPicker(){
        return driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");
    }

}
