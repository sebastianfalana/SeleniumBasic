package homework_SeleniumBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework_DataPickers extends TestBase {

    String pickUserDate = "08/31/2022";
    int pickMonthByUser = 7;
    int pickYearByUser = 2022;
    @Test
    public void shouldPickDate(){
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        driver.findElement(By.cssSelector("#datepicker")).click();

        if (getCurrentYear() == pickYearByUser){
            pickCorrectMonth();
        }else if(getCurrentYear() > pickYearByUser){
            while (getCurrentYear() != pickYearByUser){
                getPrevArrowHandler().click();
            }
           pickCorrectMonth();
        }else {
            while (getCurrentYear() != pickYearByUser){
                getNextArrowHandler().click();
            }
            pickCorrectMonth();
        }

        System.out.println(getDataPicker());
        Assert.assertEquals(getDataPicker(),pickUserDate);
    }


    public WebElement getNextArrowHandler(){
        return driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']"));
    }
    public WebElement getPrevArrowHandler(){
        return driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-w']"));
    }

    public int getCurrentYear(){
        return Integer.parseInt(getFifthRowForthCell().getAttribute("data-year"));
    }

    public int getCurrentMonth(){
        return Integer.parseInt(getFifthRowForthCell().getAttribute("data-month"));
    }

    public int getCurrentDay(){
        return Integer.parseInt(getFifthRowForthCell().getAttribute("data-month"));
    }

    public WebElement getFifthRowForthCell(){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        WebElement fifthRow = rows.get(4);

        List<WebElement> rowCells = fifthRow.findElements(By.cssSelector("td"));
        return rowCells.get(3);
    }

    public String getDataPicker(){
        return driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");
    }

    public void pickCorrectMonth(){
        if (getCurrentMonth() == pickMonthByUser){
            getFifthRowForthCell().click();
        }else if(getCurrentMonth() > pickMonthByUser){
            while (getCurrentMonth() != pickMonthByUser){
                getPrevArrowHandler().click();
            }
            getFifthRowForthCell().click();
        }else {
            while (getCurrentMonth() != pickMonthByUser){
                getNextArrowHandler().click();
            }
            getFifthRowForthCell().click();
        }
    }

    public void pickCorrectDay(){

    }

}
